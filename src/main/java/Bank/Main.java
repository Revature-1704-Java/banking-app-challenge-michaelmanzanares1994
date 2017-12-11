package Bank;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Account account = new Account();
		account.setAccount("567");
		account.getAccount();
				
		OpenAccount userAccount = new OpenUserAccount();
		OpenAccount workerAccount = new OpenWorkerAccount();
		
		Parser parser = new Parser();
		parser.checkUser();
		
//		userAccount.openAccount();
//		userAccount.deposit();
//		userAccount.withdrawl();
//		
//		workerAccount.openAccount();
//		workerAccount.deposit();
//		workerAccount.withdrawl();

		Scanner scanner = new Scanner(System.in);								// get input info
		String userChoice = "";
		
		System.out.println("What would you like to do? You can: \ndeposit or withdrawl");
		userChoice = scanner.nextLine();
		if(userChoice.equals("deposit")) {
			userAccount.deposit();
		} else if(userChoice.equals("withdrawl")) {
			userAccount.withdrawl();
		} else {
			System.out.println("What do you want to do?");
		}
	}
}

