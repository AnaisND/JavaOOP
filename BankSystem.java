import java.util.Scanner;

public class BankSystem {
public static void main(String[] args) {
	Scanner scanner2 = new Scanner(System.in);
	int nr; int i;
	System.out.print("\nNumber of accounts to initialise: ");
	nr = scanner2.nextInt();
	CustomerDetails C[] = new CustomerDetails[nr];
	for(i=0;i<C.length;i++) {
		C[i] = new CustomerDetails();
		C[i].InitializeAccount();
		C[i].DisplayAccount();
	}
	
	int choice;
	do {
		System.out.println("\n1 -> Display Account Details \n2 -> Search Account \n3 -> Deposit cash \n4 -> Withdraw cash \n5 -> Exit");
		choice = scanner2.nextInt();
		switch(choice) {
		case 1:
			for(i=0;i<C.length;i++) {
				C[i].DisplayAccount();
		}
			break;
		case 2:
			String accno;
			System.out.print("\nAccount Number: ");
			accno = scanner2.next();
			boolean found = false;
			for(i=0;i<C.length;i++) {
				found = C[i].Search(accno);
				if(found) {
					break;
				}
			}
			if(!found) {
				System.out.print("\nAccount doesn't exist.");
			}
			break;
		case 3:
			String accno2;
			System.out.print("\nAccount Number: ");
			accno2 = scanner2.next();
			boolean found2 = false;
			for(i=0;i<C.length;i++) {
				found2 = C[i].Search(accno2);
				if(found2) {
					C[i].Deposit();
					break;
				}
			}
			if(!found2) {
				System.out.print("\nAccount doesn't exist.");
			}
			break;
		case 4:
			String accno3;
			System.out.print("\nAccount Number: ");
			accno3 = scanner2.next();
			boolean found3 = false;
			for(i=0;i<C.length;i++) {
				found3 = C[i].Search(accno3);
				if(found3) {
					C[i].Withdraw();
					break;
				}
			}
			if(!found3) {
				System.out.print("\nAccount doesn't exist.");
			}
			break;
		case 5:
			System.out.print("\nGoodbye!.");
			break;
				
	}
	}
	while(choice != 5);
}
}

