package reit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableClerk implements Runnable {
	ClerkDetails fClerkDetails;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private Assets fAssets;
	private AtomicInteger fNumRentalRequests; 
	private Object fLock; // used for continueRunning

	private CyclicBarrier fNewShift;

	private int fSleepTime;
	private boolean fSlept;
	public RunnableClerk(ClerkDetails ClerkDetails,
			BlockingQueue<RentalRequest> RentalRequests, Assets Assets,
			AtomicInteger NumRentalRequests, Object Lock,
			CyclicBarrier NewShift) {
		fClerkDetails = ClerkDetails;
		fRentalRequests = RentalRequests;
		fAssets = Assets;
		fNumRentalRequests = NumRentalRequests;
		fLock = Lock;
		fNewShift = NewShift;
		fSlept = false;
		fSleepTime = 0;

	}

	@Override
	public void run() {
		while (fNumRentalRequests.get() != 0) {
			fSlept = false;
			RentalRequest rentalRequest=takeRequest(); //and update the that request have been taking care of
			if(rentalRequest==null) endDay();	//no need for a clerk
			
			//check for a good asset . Assets need to update Asset to booked, so this result will always be relevant

			Asset foundOne = findAsset(rentalRequest);
			double distance = foundOne.getLocation().CalculateDistance(
					fClerkDetails.getLocation());
			goToSleep((int) distance);
			rentalRequest.setAsset(foundOne);
			rentalRequest.setRequestStatus("FULLFILLED"); //this function needs to awake customer
			endDay();
			}
		if (!fSlept)
			endDay();
	}

	private Asset findAsset(RentalRequest rentalRequest) {
		synchronized(fClerkDetails){
			Asset asset=null;
			while(asset==null){
				asset=fAssets.find(rentalRequest);
				if (asset == null) {
					try {
						fClerkDetails.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return asset;
		}
	}

	private void endDay() {
		if (fSleepTime >= 8 || fNumRentalRequests.get() == 0) {
			// enter to cycle barrier if end of day or is useless
			try {
				fSlept = true;
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
				if(fNumRentalRequests.get()!=0){
					try {
						rentalRequest=fRentalRequests.take();
						fNumRentalRequests.decrementAndGet(); //one rental request has been managed

					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			return rentalRequest;
				}
	}

	private void goToSleep(int distance) {
		fSleepTime = fSleepTime + 2 * distance;
		try {
			Thread.sleep(2 * distance * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}
}
