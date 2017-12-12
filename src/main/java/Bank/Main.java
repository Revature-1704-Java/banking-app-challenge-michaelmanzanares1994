package Bank;

public class Main {
	public static void main(String[] args) {
		double runningBalance = 0;
		Parser parser = new Parser();
		
		runningBalance = parser.start();
		parser.chooseFuncitonality(runningBalance);
		
	}
}