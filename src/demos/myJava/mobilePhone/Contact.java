package demos.myJava.mobilePhone;

public class Contact {
	
	private String name;
	private long phone_number;
	
	
	public Contact() {
		super();
	}
	public Contact(String name, long phone_number) {
		super();
		this.name = name;
		this.phone_number = phone_number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", phone_number=" + phone_number + "]";
	}
	
	

}
