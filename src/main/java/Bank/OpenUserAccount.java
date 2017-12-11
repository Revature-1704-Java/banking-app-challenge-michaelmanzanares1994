package Bank;

import java.io.*;

public class OpenUserAccount extends OpenAccount{			// polymorphism
	void openAccount() {
		System.out.println("Opening user account");

	}
	
	void deposit() {
		System.out.println("Desposting from user now...");
	}
	
	void withdrawl() {
		System.out.println("Withdrawing from user now...");
	}
}
