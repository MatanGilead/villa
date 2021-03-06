package reit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

class RunnableClerk implements Runnable {
	ClerkDetails fClerkDetails;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private Assets fAssets;
	private AtomicInteger fNumRentalRequests; 
	private Object fLock; // used for continueRunning
	private Logger logger;
	private CyclicBarrier fNewShift;
	private AtomicBoolean killClerks;
	private int fSleepTime;

	RunnableClerk(ClerkDetails ClerkDetails,
			BlockingQueue<RentalRequest> RentalRequests, Assets Assets,
			AtomicInteger NumRentalRequests, Object Lock,
			CyclicBarrier NewShift, AtomicBoolean needToGo) {
		fClerkDetails = ClerkDetails;
		fRentalRequests = RentalRequests;
		fAssets = Assets;
		fNumRentalRequests = NumRentalRequests;
		fLock = Lock;
		fNewShift = NewShift;
		fSleepTime = 0;
		logger = MyLogger.getLogger("RunnableClerk");
		killClerks = needToGo;
	}

	@Override
	public void run() {

		while (fNumRentalRequests.get() != 0) {
			RentalRequest rentalRequest=takeRequest(); //and update the that request have been taking care of
			if(rentalRequest==null) {
				endDay();	//no need for a clerk
			}
			else {
			//check for a good asset . Assets need to update Asset to booked, so this result will always be relevant

			Asset foundOne = findAsset(rentalRequest);
			double distance = foundOne.getLocation().CalculateDistance(
					fClerkDetails.getLocation());
			goToSleep((int) distance);
			rentalRequest.setAsset(foundOne);
			logger.info("Clerk "+fClerkDetails.getName()+" finished dealing with rentalrequest "+rentalRequest.getId());
			rentalRequest.setRequestStatus("FULLFILLED");
			synchronized (rentalRequest) {
				rentalRequest.notifyAll();
			}
			endDay();
			}
		}
		while (killClerks.get() == false) {
			System.out.println(killClerks);
			endDay();
			}



	}


	private Asset findAsset(RentalRequest rentalRequest) {
		synchronized(fClerkDetails){
			synchronized (rentalRequest) {
			logger.info("Clerk " + fClerkDetails.getName()+ " is looking for asset for" + rentalRequest.getId());
			Asset asset=null;
			while(asset==null){
				asset=fAssets.find(rentalRequest);
				if (asset == null) {
					try {
						logger.info("Clerk " + fClerkDetails.getName()+ " couldn't find an asset so he goes to sleep untill a new asset will show up! Rental Request:" + rentalRequest.getId());
						fClerkDetails.wait();
						logger.info("Clerk " + fClerkDetails.getName()+ " has woke up! Rental Request:" + rentalRequest.getId());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			logger.info("Clerk " + fClerkDetails.getName()+ " found an asset! asset name"+asset.getName() + rentalRequest.getId());
			return asset;
		}
		}
	}
	private void endDay() {
		if (fSleepTime >= 8 || fNumRentalRequests.get() == 0) {
			if(fSleepTime >= 8) logger.info("Clerk "+ fClerkDetails.getName()+" finished his shift! sleeping");
			try {
				fSleepTime = 0;
				fNewShift.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private RentalRequest takeRequest() {
			RentalRequest rentalRequest=null;
			synchronized(fLock){
				if(fNumRentalRequests.get()==0) return null;
				else fNumRentalRequests.decrementAndGet();
			}
		try {
			rentalRequest = fRentalRequests.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return rentalRequest;
	}

	private void goToSleep(int distance) {
		fSleepTime = fSleepTime + 2 * distance;
		logger.info("Clerk "+fClerkDetails.getName()+" is going to sleep for"+2*distance);
		try {
			Thread.sleep(2 * distance * 1000);//
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}


	}
}
