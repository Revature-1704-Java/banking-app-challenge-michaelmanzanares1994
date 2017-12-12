package Bank;
import java.io.*;
import java.util.*;

public class Account {
	private Scanner reader;
	private double accountBalance = 0.00;
	
	public Account() {
		reader = new Scanner(System.in);
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void createAccount() {
		System.out.println("Input desired username and password:\n");
		String newInputName = reader.nextLine();
		String newInputPassword = reader.nextLine();
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("UserInfo.txt", "UTF-8");
			writer.println(newInputName);
			writer.println(newInputPassword);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file.");			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
	}
	
	public double getAccount1Balance(String acct1) {
		double Balance = 20;
		System.out.println("your balance in account " + acct1 + " is: " + Balance);
		
		return Balance;
	}
	
	public double getAccount2Balance(String acct2) {
		double Balance = 30;
		System.out.println("your balance in account " + acct2 + " is: " + Balance);
		
		return Balance;
	}
}