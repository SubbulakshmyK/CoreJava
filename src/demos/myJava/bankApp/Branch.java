package demos.myJava.bankApp;

import java.util.ArrayList;

public class Branch {

	private String Name;
	private ArrayList<Customer> customers;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public Branch(String name) {
		super();
		Name = name;
		this.customers = new ArrayList<Customer>();
	}

	public Branch() {
		super();
	}
	
	public void addCustomer(String Name, double transaction) {
		if(custPosition(Name)>=0) {
			System.out.println("Customer Already exists. Please add Transaction.");
		}
		else {
			Customer cust = new Customer(Name, transaction);
			this.customers.add(cust);
			System.out.println("Customer added successfully...");
		}
		
	}
	public void addTransaction(String Name, double transaction) {
		Customer cust = null;
		int index = custPosition(Name);
		if(index >= 0) {
			cust = this.customers.get(index);
			cust.addTransaction(transaction);
			System.out.println("Transaction Added successfully...");
		}
		else {
			System.out.println("Customer not exists. New Customer added.");
			cust = new Customer(Name, transaction);
			//cust.addTransaction(transaction);
			this.customers.add(cust);
			System.out.println("Transaction Added successfully...");
		}		
	}
	
	private int custPosition(String name) {
		int index=-1;
		for(int i=0; i<this.customers.size();i++) {
			if(name.equals(this.customers.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
		
	}
	@Override
	public String toString() {
		return "Branch [Name=" + Name + ", customers=" + customers + "]";
	}
	
	public Customer findCustomer(String name) {
		Customer cust =null;
		for(Customer c: this.customers)
			if(name.equals(c.getName())) {
				cust=c;
				break;
			}
		return cust;
	}
}
