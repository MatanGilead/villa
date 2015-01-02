package reit;

import java.util.concurrent.Semaphore;

class RepairTool {
	private String fName;
	private Semaphore fQuantity;

	RepairTool(String name, int count) {
		fName = name;
		fQuantity = new Semaphore(count);
		// fLock = new Semaphore(1, true);
		// private Semaphore fLock;
	}

	String getName() {
		return fName;
	}

	// public Semaphore getLock() {
	// return fLock;
	// }

	// public Semaphore getQuantity() {
	// return fQuantity;
	// }

	boolean acquireTool(int quantity) {
		return fQuantity.tryAcquire(quantity);
	}



	void setQuantity(int quantity) {
		fQuantity.release(quantity);
	}
}
