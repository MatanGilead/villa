package reit;

import java.util.concurrent.Semaphore;

public class RepairTool {
	private String fName;
	private int fQuantity;
	private Semaphore fLock;
	public RepairTool(String name, int count) {
		fName = name;
		fQuantity = count;
		fLock = new Semaphore(1, true);

	}

	public String getName() {
		return fName;
	}

	public Semaphore getLock() {
		return fLock;
	}

	public int getQuantity() {
		return fQuantity;
	}

	public void setQuantity(int quantity) {
		fQuantity = quantity;
	}
}
