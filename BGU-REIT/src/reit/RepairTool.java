package reit;

import java.util.concurrent.Semaphore;

public class RepairTool {
	private String fName;
	private Semaphore fQuantity;

	public RepairTool(String name, int count) {
		fName = name;
		fQuantity = new Semaphore(count);
		// fLock = new Semaphore(1, true);
		// private Semaphore fLock;
	}

	public String getName() {
		return fName;
	}

	// public Semaphore getLock() {
	// return fLock;
	// }

	// public Semaphore getQuantity() {
	// return fQuantity;
	// }

	public boolean acquireTool(int quantity) {
		return fQuantity.tryAcquire(quantity);
	}



	public void setQuantity(int quantity) {
		fQuantity.release(quantity);
	}
}
