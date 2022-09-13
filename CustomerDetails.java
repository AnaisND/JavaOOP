import java.util.Scanner;

public class CustomerDetails {
	private String AccountNumber;
	private String AccountName;
	private String AccountType;
	private double AccountBalance;
	private String AccountCurrency;
	
	Scanner scanner = new Scanner(System.in);
	
	public void InitializeAccount() {
		System.out.print("Account Number: ");
		AccountNumber = scanner.next();
		System.out.print("Customer Name: ");
		AccountName = scanner.next();
		System.out.print("Account Type: ");
		AccountType = scanner.next();
		System.out.print("Current Account Balance: ");
		AccountBalance = scanner.nextDouble();
		System.out.print("Currency: "); //USD, EUR, GPD
		AccountCurrency = scanner.next();
		
	}
	
	public void DisplayAccount() {
		System.out.print("\nAccount Number: " + AccountNumber);
		System.out.print("\nCustomer Name: " + AccountName);
		System.out.print("\nAccount Type: " + AccountType);
		System.out.print("\nCurrent Account Balance: " + AccountBalance);
		System.out.print("\nAccount Currency: " + AccountCurrency);
	}
	
	double CurrencyConvertor(String f, String l, double n) {
		String d = "USD";
		String e = "EUR";
		String p = "GBP";
		if((f.compareTo(d)==0)&&(l.compareTo(e)==0)) {
			n = n*0.99948619;
		}
		else if((f.compareTo(d)==0)&&(l.compareTo(p)==0)) {
			n = n*0.86758403;
		}
		else if((f.compareTo(e)==0)&&(l.compareTo(d)==0)) {
			n = n*1.0005141;
		}
		else if((f.compareTo(e)==0)&&(l.compareTo(p)==0)) {
			n = n*0.86802233;
		}
		else if((f.compareTo(p)==0)&&(l.compareTo(d)==0)) {
			n = n*1.1526261;
		}
		else if((f.compareTo(p)==0)&&(l.compareTo(e)==0)) {
			n = n*1.1520441;
		}
		else {
			System.out.print("\nError! Please Try Again.");
		}
		return n;
	}
	
	public void Deposit() {
		double n; 
		double copy;
		String c;
		System.out.print("\nAmmount you want to deposit: ");
		n = scanner.nextDouble();
		copy = n;
		System.out.print("\nCurrency: ");
		c = scanner.next();
		if(AccountCurrency.compareTo(c) == 0) {
			AccountBalance += n;
			System.out.print("\nCurrent Account Balance: " + AccountBalance + AccountCurrency);
		}
		else {
			n = CurrencyConvertor(AccountCurrency, c, copy);
			AccountBalance += n;
			System.out.print("\nCurrent Account Balance: " + AccountBalance + AccountCurrency);
		}
	}
	
	public void Withdraw() {

		double n;
		String t1 = "Credit";
		String t2 = "Debit";
		System.out.print("\nAmmount you want to retract: ");
		n = scanner.nextDouble();
		if(AccountType.compareTo(t1)==0) {
			AccountBalance -= n;
			System.out.print("\nCurrent Account Balance: " + AccountBalance + AccountCurrency);
		}
		else if(AccountType.compareTo(t2)==0) {
			if(AccountBalance < n) {
				System.out.print("\nInsufficient funds!");
			}
			else {
				AccountBalance -= n;
				System.out.print("\nAmount Withdrawn: " + n + AccountCurrency);
				System.out.print("\nCurrent Account Balance: " + AccountBalance + AccountCurrency);
			}
		}
		else {
			System.out.print("\nError! Please try again.");
		}
	}
	
	public boolean Search(String accno) {
		if(accno.compareTo(AccountNumber)==0)
		{
			DisplayAccount();
			return (true);
		}
		else {
			return (false);
		}
	}
}
