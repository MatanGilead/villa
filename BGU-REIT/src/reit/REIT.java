package reit;

public class REIT {
	public static void main(String[] args) {
		Management management = new Management();
		Drive setElements = new Drive(management);
		management.start();
	}
}
