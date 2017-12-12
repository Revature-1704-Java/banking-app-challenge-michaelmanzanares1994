package Bank;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Parser {
	private Scanner reader;
	private double accountBalance = 0;
	private double Balance = 0;
	private static DecimalFormat decimal = new DecimalFormat(".##");
	
	public Parser()	{
		reader = new Scanner(System.in);
	}

	public void checkUser() {
		System.out.println("Input username and password:\n");
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
			} else {
				System.out.println("Incorrect Username or password.\n");
				exit();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
	}
	
	public double displayBalance() {
		Account account = new Account();
		String acctNum;
		double accountNum;
		double inputNumber;
		double accountBalance = 0;
		
		System.out.println("Input account number: ");
		acctNum = reader.nextLine();
		inputNumber = Double.parseDouble(acctNum);
		
		if(inputNumber == account.getAccountNumber()) {
			accountBalance = account.getAccountBalance();
			return accountBalance;
		} else {
			System.out.println("Incorrect account number. Try again.");
			return inputNumber;								// not what i want
		}
	}
	
	public void chooseFuncitonality() {
		if(Balance <= 0) {
			System.out.println("You can only deposit or exit.");
			String userChoice = reader.nextLine();

			if(userChoice.equals("deposit")) {
				Balance = deposit();
				chooseFuncitonality();
			} else if(userChoice.equals("exit")){
				System.out.println("Your current overall balance is: " + decimal.format(Balance) + "\nGoodbye!");
				exit();
			} else {
				System.out.println("That is not a valid command.");
				chooseFuncitonality();
			}
		} else {
			System.out.println("What would you like to do? You can: \ndeposit, withdrawl, or exit");
			String userChoice = reader.nextLine();

			if(userChoice.equals("deposit")) {
				Balance = deposit();
				chooseFuncitonality();
			} else if(userChoice.equals("withdrawl")) {
				Balance = withdrawl();
				chooseFuncitonality();
			} else if(userChoice.equals("exit")){
				System.out.println("Your current overall balance is: " + decimal.format(Balance) + "\nGoodbye!");
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
		System.out.println("How much would you like to withdrawl?\n>");
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
