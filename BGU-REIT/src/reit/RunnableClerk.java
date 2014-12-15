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
	private Object fLock; //used for continueRunning
	private AtomicInteger fNumOfClerks;
	private CyclicBarrier fNewShift;
	private boolean fLastShift;
	private int fSleepTime;

	public RunnableClerk(ClerkDetails ClerkDetails,
			BlockingQueue<RentalRequest> RentalRequests, Assets Assets,
			AtomicInteger NumRentalRequests, Object Lock,
			AtomicInteger NumOfClerks, CyclicBarrier NewShift) {
		fClerkDetails = ClerkDetails;
		fRentalRequests = RentalRequests;
		fAssets = Assets;
		fNumRentalRequests = NumRentalRequests;
		fLock = Lock;
		fNumOfClerks = NumOfClerks;
		fNewShift = NewShift;
		fLastShift = false;
		fSleepTime = 0;
	}
	
	@Override
	public void run() {
		while(fNumRentalRequests.get()!=0 && !fLastShift){
			//if there are more rental requests than clerk we keep runing, if we didnt do the last shift we continue running
			if(fNumOfClerks.get()<=fNumRentalRequests.get() || continueRunning()){
			//take rental request
				RentalRequest rentalRequest=takeRequest();
			//check for a good asset
				//Assets need to update Asset to booked, so this result will always be relevant
				Asset foundOne=fAssets.find(rentalRequest); 
				double distance = foundOne.getLocation().CalculateDistance(
						fClerkDetails.getLocation());
				goToSleep((int) distance);
				rentalRequest.setAsset(foundOne);
				rentalRequest.setRequestStatus("FULLFILLED"); //this function needs to awake customer
				fNumRentalRequests.decrementAndGet(); //one rental request has been managed
				endDay();

			}
		}
	}	
		private void endDay() {
			if(fSleepTime>=8 && !fLastShift){ //enter to cycle barrier, or make a step to end thread
				try {
					fSleepTime=0;
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
			try {
				rentalRequest=fRentalRequests.take();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return rentalRequest;
		
	}
		private void goToSleep(int distance) {
			fSleepTime=fSleepTime+2*distance;
			try {
				Thread.sleep(2*distance*1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
	}
		private boolean continueRunning() {
		synchronized (fLock) {
			fLastShift = true;
			if (fNumOfClerks.get() > fNumRentalRequests.get()) {
				fNumOfClerks.getAndDecrement();
				return false;
			}
		}
		return true;
	}

}
