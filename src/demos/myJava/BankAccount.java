package demos.myJava;

public class BankAccount {
	String acc_number;
	String cust_name;
	String email;
	String phone_no;
	double balance;
	
	public BankAccount() {
		super();
		this.acc_number = "WB10089";
		this.cust_name = "Suhand";
		this.email = "mail2S@gmail.com";
		this.phone_no = "9988998899";
		this.balance = 1000;
	}
	public BankAccount(String acc_number, String cust_name, String email, String phone_no, double balance) {
		super();
		this.acc_number = acc_number;
		this.cust_name = cust_name;
		this.email = email;
		this.phone_no = phone_no;
		this.balance = balance;
	}
	public String getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acc_number=" + acc_number + ", cust_name=" + cust_name + ", email=" + email + ", phone_no="
				+ phone_no + ", balance=" + balance + "]";
	}

	public void deposit(double amount) {
		if(amount<=0)
			System.out.println("Invalid amount to Deposit");
		else {
			this.balance+=amount;
			System.out.println("Deposited amount="+amount);
			System.out.println("Balance amount="+this.balance);
		}
	}
	
	public void withdraw(double amount) {
		if(amount<=0)
			System.out.println("Invalid amount to withdraw");
		else if(this.balance < (amount+500))
			System.out.println("Insuffeciant Fund. Can not withdraw more than "+(this.balance-500));
		else {
			this.balance -= amount;
			System.out.println("Amount withdrawn="+amount);
			System.out.println("Balance amount="+this.balance);
		}
	}
}
