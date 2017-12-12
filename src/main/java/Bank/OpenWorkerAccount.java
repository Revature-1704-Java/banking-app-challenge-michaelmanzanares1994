package Bank;

import java.io.*;

public class OpenWorkerAccount extends OpenAccount {			// polymorphism
	double accountBalance;
	void openAccount() {
		System.out.println("Opening worker account");
	}
	
	double deposit() {
		System.out.println("Desposting from worker now...");
		return accountBalance;
	}
	
	double withdrawl() {
		System.out.println("Withdrawing from worker now...");
		return accountBalance;
	}
	
	boolean exit() {
		return false;
	}
}
