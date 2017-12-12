package Bank;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Parser {
	private static DecimalFormat decimal = new DecimalFormat(".##");
	private double accountBalance = 0;

	private Scanner reader;
	private Account account;
	
	public Parser()	{
		reader = new Scanner(System.in);
		account = new Account();
	}
	
	public double start() {		
		System.out.println("What would you like to do? You can:\ncreate account or open account\n");
		String answer = reader.nextLine();
		if(answer.equals("create account")) {
			account.createAccount();					// add new user to text file. func. needs work
		} else if(answer.equals("open account")) {
			accountBalance = accessAccount();			// choose correct account from user
			return accountBalance;
		} else {
			System.out.println("Invalid command. Try again.");
			start();
		}
		System.out.println("you reeeeally messed up.");
		return accountBalance;
	}
	
	public double accessAccount() {
		final String FILENAME = "UserInfo.txt";
		String inputName, inputPassword;
		
		System.out.println("Input username and password:\n");
		inputName = reader.nextLine();
		inputPassword = reader.nextLine();

		try {
			BufferedReader in;
			in = new BufferedReader(new FileReader(FILENAME));				// access file
			String acctInfo;

			List<String> list = new ArrayList<String>();					// create array list of information from text file
			while((acctInfo = in.readLine()) != null){
			    list.add(acctInfo);
			}

			String[] stringArr = list.toArray(new String[0]);				// create array of strings from the list
			@SuppressWarnings("unused")
			String textUser = stringArr[0]; 
			String textUserName = stringArr[1]; 
			String textPassword = stringArr[2];
			String userAcct1 = stringArr[3]; 
			String userAcct2 = stringArr[4]; 
			@SuppressWarnings("unused")
			String textUser2 = stringArr[5]; 
			
			if(inputName.equals(textUserName) & inputPassword.equals(textPassword)) {		// compare input to text info
				System.out.println("You are logged in!");
				System.out.println("Which account would you like to access?\n");				// choose correct account
				
				String inputAcct = reader.nextLine();
				in.close();
				if(inputAcct.equals(userAcct1)) {
					System.out.println("user account 1 number is: " + userAcct1);
					accountBalance = account.getAccount1Balance(userAcct1);

					return accountBalance;
					
				} else if(inputAcct.equals(userAcct2)) {
					accountBalance = account.getAccount2Balance(userAcct2);
					in.close();
					return accountBalance;
				} else {
					System.out.println("Invalid account number. Try again");				// fix error checking
				}
			} else {
				System.out.println("Incorrect Username or password.\n");					// fix error checking
				//exit();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
		System.out.println("you messed up");
		return accountBalance;
	}
	
	public void chooseFuncitonality(double runningBalance) {
		if(runningBalance <= 0) {
			System.out.println("You can only deposit or exit.");
			String userChoice = reader.nextLine();

			if(userChoice.equals("deposit")) {
				runningBalance = deposit();
				chooseFuncitonality(runningBalance);
			} else if(userChoice.equals("exit")){
				System.out.println("Your current overall balance is: " + decimal.format(runningBalance) + "\nGoodbye!");
				exit();
			} else {
				System.out.println("That is not a valid command.");
				chooseFuncitonality(runningBalance);
			}
		} else {
			System.out.println("What would you like to do? You can: \ndeposit, withdrawl, or exit");
			String userChoice = reader.nextLine();

			if(userChoice.equals("deposit")) {
				runningBalance = deposit();
				chooseFuncitonality(runningBalance);
			} else if(userChoice.equals("withdrawl")) {
				runningBalance = withdrawl();
				chooseFuncitonality(runningBalance);
			} else if(userChoice.equals("exit")){
				System.out.println("Your current overall balance is: " + decimal.format(runningBalance) + "\nGoodbye!");
				exit();
			} else {
				System.out.println("That is not a valid command.\nGoodbye.");
			}
		}
	}
	
	public double deposit() {
		double depositAmount;
		String deposit;
		
		System.out.println("How much would you like to deposit?\n>");
		deposit = reader.nextLine();
		
		depositAmount = Double.parseDouble(deposit);
		
		accountBalance += depositAmount;
		System.out.println("Account Balance is now: " + decimal.format(accountBalance));
		return accountBalance;
	}
	
	public double withdrawl() {
		double withdrawlAmount;
		String withdrawl;
		System.out.println("How much would you like to withdrawl:\n");
		withdrawl = reader.nextLine();
		
		withdrawlAmount = Double.parseDouble(withdrawl);
		
		accountBalance -= withdrawlAmount;
		System.out.println("Account Balance is now: " + decimal.format(accountBalance));
		return accountBalance;
	}
	
	public boolean exit() {
		return false;
	}
	
}
