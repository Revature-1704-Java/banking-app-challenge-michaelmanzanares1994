package Bank;

import java.util.*;
import java.io.*;

public class Parser {
	private Scanner reader;
	private double accountBalance = 0;
	private double Balance = 0;
	
	public Parser()	{
		reader = new Scanner(System.in);
	}

	public void checkUser() {
		System.out.println("Hello. Input username and password:\n");
		String inputName = reader.nextLine();
		String inputPassword = reader.nextLine();

		
		final String FILENAME = "UserInfo.txt";								// get text info
		try {
			BufferedReader in;
			in = new BufferedReader(new FileReader(FILENAME));				// access file
			String acctInfo;

			List<String> list = new ArrayList<String>();					// create list of information from text file
			while((acctInfo = in.readLine()) != null){
			    list.add(acctInfo);
			}
			in.close();

			String[] stringArr = list.toArray(new String[0]);
			String textUserName = stringArr[0]; 
			String textPassword = stringArr[1];
			
			if(inputName.equals(textUserName) & inputPassword.equals(textPassword)) {		// compare input to text info
				System.out.println("You logged in!");
			}
			else {
				System.out.println("Incorrect Username or password.");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
	}
	
	public String getAccount() {
		System.out.println("Input account number");
		String acctNum = reader.nextLine();
		return acctNum;
	}
	
	public void chooseFuncitonality() {
		if(Balance <= 0) {
			System.out.println("You're balance is empty!");
		}
		System.out.println("What would you like to do? You can: \ndeposit, withdrawl, or exit");
		String userChoice = reader.nextLine();

		if(userChoice.equals("deposit")) {
			Balance += deposit();
			chooseFuncitonality();
		} else if(userChoice.equals("withdrawl")) {
			Balance += withdrawl();
			chooseFuncitonality();
		} else if(userChoice.equals("exit")){
			System.out.println("Your current overall balance is: " + Balance);
			exit();
		} else {
			System.out.println("That is not a valid command.\nGoodbye.");
		}
	}
	
	public double deposit() {
		double val;
		String depositAmount;
		System.out.println("How much would you like to deposit?\n>");
		depositAmount = reader.nextLine();
		
		val = Double.parseDouble(depositAmount);
		
		accountBalance += val;
		System.out.println("Account Balance is now: " + accountBalance);
		return accountBalance;
	}
	
	public double withdrawl() {
		double accountBalance = 0;
		double val;
		String withdrawlAmount;
		System.out.println("How much would you like to withdrawl?\n>");
		withdrawlAmount = reader.nextLine();
		
		val = Double.parseDouble(withdrawlAmount);
		
		accountBalance -= val;
		System.out.println("Account Balance is now: " + accountBalance);
		return accountBalance;
	}
	
	public boolean exit() {
		return false;
	}
}
