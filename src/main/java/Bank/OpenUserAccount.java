package Bank;

import java.util.*;

public class OpenUserAccount extends OpenAccount{			// polymorphism
	private Scanner reader = new Scanner(System.in);
	double accountBalance = 0;
	
	void openAccount() {
		System.out.println("Opening user account");
	}
	
	double deposit() {
		double val;
		String depositAmount;
		System.out.println("Desposting from user now...");
		System.out.println("How much would you like to deposit?\n>");
		depositAmount = reader.nextLine();
		
		val = Double.parseDouble(depositAmount);
		
		accountBalance += val;
		System.out.println("Account Balance is now: " + accountBalance);
		return accountBalance;
	}
	
	double withdrawl() {
		System.out.println("Withdrawing from user now...");
		System.out.println("How much would you like to withdrawl?\n>");
		byte withdrawlAmount = reader.nextByte();
		
		accountBalance -= withdrawlAmount;
		System.out.println("Account Balance is now: " + accountBalance);
		return accountBalance;
	}
	
	boolean exit() {
		return false;
	}
}
