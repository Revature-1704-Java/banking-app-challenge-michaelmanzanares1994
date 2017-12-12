package Bank;

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
