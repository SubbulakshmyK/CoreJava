package demos.myJava.mobilePhone;

import java.util.Scanner;

public class mainClass {

	private static Scanner s=new Scanner(System.in);
	private static MobilePhone myPhone = new MobilePhone("SS Phone");	
	
	public static void main(String[] srg) {
		printMenu();
	}

	public static void printMenu() {
		int option=1;
		do {
			System.out.println("0 - Quit \n"+
								"1 - Add Contact \n"+
								"2 - Update Contact name\n"+
								"3 - Remove Contact \n" +
								"4 - List Contacts \n"+
								"5 - Find Contact \n"+
								"Enter the Option : ");
			option = s.nextInt();

			switch(option) {
				case 0:
					System.out.println("Thank you!!!");
					break;
				case 1:
					addContact();
					break;
				case 2:
					editContact();
					break;
				case 3:
					deleteContact();
					break;
				case 4:
					listContacts();
					break;
				case 5:
					getContact();
					break;
				default:
					System.out.println("Invalid option. Please choose your option");
				}
		}while(option != 0);
		
	}
	
	private static void addContact() {
		System.out.println("Enter Contact name & phone number :");
		s.nextLine();
		String name = s.nextLine();
		System.out.println("Enter phone number :");
		long phno=Long.parseLong(s.nextLine());
		//System.out.println("AddContact Name="+name+" PhoneNumber="+phno);
		myPhone.addContact(name,phno);
	}
	private static void editContact() {
		System.out.println("Edit Options: 1- Edit Name, 2- Edit Phone Number :");
		int editOption = s.nextInt();
		if(editOption ==1) {
			System.out.println("Enter Old name to Edit:");
			s.nextLine();
			String oldName = s.nextLine();
			System.out.println("Enter Old name to Edit:");
			String newName = s.nextLine();	
			myPhone.modify(oldName, newName);
		}
		else if(editOption==2) {
			System.out.println("Enter Contact Name to Edit:");
			s.nextLine();
			String name = s.nextLine();	
			System.out.println("Enter new phone number:");
			long phno=s.nextInt();
			myPhone.modify(name, phno);
		}
		else
			System.out.println("Enter valid Edit Option.");

	}
	private static void deleteContact() {
		System.out.println("Delete Options: 1- Delete by Name, 2- Delete by Phone Number :");
		int editOption = s.nextInt();
		if(editOption ==1) {
			System.out.println("Enter name to Delete Contact:");
			String name = s.nextLine();
			myPhone.remove(name);
		}
		else if(editOption==2) {
			System.out.println("Enter Phone number to Delete Contact:");
			long phno=s.nextInt();
			myPhone.remove( phno);
		}
		else
			System.out.println("Enter valid Delete Option.");
	}
	private static void getContact() {
		System.out.println("Find Options: 1- By Name, 2- By Phone Number :");
		int editOption = s.nextInt();
		if(editOption ==1) {
			System.out.println("Enter name to Find:");
			String name = s.nextLine();
			myPhone.getContact(name);
		}
		else if(editOption==2) {
			System.out.println("Enter Phone number to Find:");
			long phno=s.nextInt();
			myPhone.getContact( phno);
		}
		else
			System.out.println("Enter valid Find Option.");
	}
	
	private static void listContacts() {
		myPhone.printContacts();
	}
}
