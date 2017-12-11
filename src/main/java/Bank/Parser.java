package Bank;

import java.util.*;
import java.io.*;

public class Parser {
	private Scanner reader;
	
	public Parser()	{
		reader = new Scanner(System.in);
	}

	public void checkUser() {
		Scanner input = new Scanner(System.in);								// get input info
		System.out.println("Hello. Input username and password:\n");
		String inputName = input.nextLine();
		String inputPassword = input.nextLine();
		
		System.out.println("user input the name: " + inputName);
		System.out.println("user input the password: " + inputPassword);
		
		final String FILENAME = "UserInfo.txt";								// get text info
		try {
			BufferedReader in;
			in = new BufferedReader(new FileReader(FILENAME));
			String str;

			List<String> list = new ArrayList<String>();
			while((str = in.readLine()) != null){
			    list.add(str);
			}

			String[] stringArr = list.toArray(new String[0]);
			String textUserName = stringArr[0]; 
			String textPassword = stringArr[1];
			
			if(inputName.equals(textUserName) && inputPassword.equals(stringArr[1])) {
				System.out.println("You logged in!");
			}
			else {
				System.out.println("Incorrect Username or password.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
