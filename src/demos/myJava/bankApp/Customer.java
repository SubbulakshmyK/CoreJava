package demos.myJava.bankApp;

import java.util.ArrayList;

public class Customer {

	private String Name;
	private ArrayList<Double> Transactions;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<Double> getTransactions() {
		return Transactions;
	}
	public void setTransactions(ArrayList<Double> transactions) {
		Transactions = transactions;
	}
	
	public Customer(String name, double transaction) {
		super();
		Name = name;
		Transactions = new ArrayList<Double>();
		Transactions.add(transaction);
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [Name=" + Name + ", Transactions=" + Transactions + "]";
	}
	
	public boolean addTransaction( double transaction) {
		this.Transactions.add(transaction);
		return true;
	}
}
