package Bank;

import java.io.*;

public class OpenWorkerAccount extends OpenAccount {			// polymorphism
	void openAccount() {
		System.out.println("Opening worker account");

	}
	
	void deposit() {
		System.out.println("Desposting from worker now...");
	}
	
	void withdrawl() {
		System.out.println("Withdrawing from worker now...");
	}
}
