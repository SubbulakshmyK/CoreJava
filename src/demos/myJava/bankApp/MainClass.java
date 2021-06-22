package demos.myJava.bankApp;

import java.util.Scanner;

public class MainClass {
	private static Scanner s = new Scanner(System.in);
	static Bank bank;
	
	public static void main(String[] arg) {
		bank = createBank();
		printMenu();
		
	}
	public static void printMenu() {
		int option=1;
		do {
			System.out.println("0 - Quit \n"+
								"1 - Add Branch \n"+
								"2 - Add Customer\n"+
								"3 - Add Transaction \n" +
								"4 - List Braches \n"+
								"Enter the Option : ");
			option = s.nextInt();

			switch(option) {
				case 0:
					System.out.println("Thank you!!!");
					break;
				case 1:
					addBranch();
					break;
				case 2:
					addCustomer();
					break;
				case 3:
					addTransaction();
					break;
				case 4:
					printBranches();
					break;
				default:
					System.out.println("Invalid option. Please choose your option");
				}
		}while(option != 0);
		
	}
	public static Bank createBank() {
		System.out.println("Enter Bank Name :");
		s.nextLine();
		String bankName = s.nextLine();
		Bank bank= new Bank(bankName);
		return bank;
	}
	
	public static void addBranch() {
		System.out.println("Enter Branch Name :");
		s.nextLine();
		String brancName = s.nextLine();
		bank.addBranch(brancName);
	}
	public static void addCustomer() {
		System.out.println("Enter Branch Name :");
		s.nextLine();
		String brancName = s.nextLine();
		Branch branch = bank.getBranch(brancName);
		if(branch !=null) {
			System.out.println("Enter Customer Name :");
			String custName = s.nextLine();
			System.out.println("Enter Transaction(double) :");
			double transc = Double.parseDouble(s.nextLine());
			branch.addCustomer(custName, transc);
		}
	}
	public static void addTransaction() {
		System.out.println("Enter Branch Name :");
		s.nextLine();
		String brancName = s.nextLine();
		Branch branch = bank.getBranch(brancName);
		if(branch !=null) {
			System.out.println("Enter Customer Name :");
			String custName = s.nextLine();
			System.out.println("Enter Transaction(double) :");
			double transc = Double.parseDouble(s.nextLine());
			branch.addTransaction(custName, transc);
		}
	}
	public static void printBranches() {
		System.out.println("Enter Branch Name :");
		s.nextLine();
		String brancName = s.nextLine();
		Branch branch = bank.getBranch(brancName);
		if(branch !=null) {
			System.out.println(branch);
		}
	}
}
