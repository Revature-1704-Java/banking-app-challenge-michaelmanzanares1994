package Bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {
	private String accountNumber;	// encapsulation
	public Account() {				// constructor
		
	}

	public String setAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		return accountNumber;
	}
	
	public String getAccount()	{
		return accountNumber;
	}
}
