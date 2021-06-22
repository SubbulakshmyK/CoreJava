package demos.myJava.mobilePhone;

import java.util.ArrayList;
import java.util.List;


public class MobilePhone {

	String MyContacts;
	List<Contact> contacts ;
	
	public MobilePhone(String myContacts) {
		super();
		MyContacts = myContacts;
		this.contacts = new ArrayList<Contact>();
	}
	
	public String getMyContacts() {
		return MyContacts;
	}
	public void setMyContacts(String myContacts) {
		MyContacts = myContacts;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public boolean addContact(String name, long phno) {
		//System.out.println("@addContact 32");
		boolean added=false;
		int nameIndex = isExists(name);
		if(nameIndex >=0 ) {
			System.out.println(name +" is already in the Contact list. ==>"+getContact(name));
		}
		else {
			int phnoIndex = isExists(phno);
			if( phnoIndex >=0 ) {
				System.out.println(phno +" is already in the Contact list. ==>"+getContact(phno));
			}
			else {
				Contact ct=new Contact(name, phno);
				this.contacts.add(ct);
				System.out.println("Contact Added : "+ct);
				added = true;
			}
		}
		return added;
	}
	
	public boolean modify(String name, long phno) {
		//System.out.println("@modify 55");
		boolean updated=false;
		int index = isExists(name);
		if(index<0) {
			System.out.println(name +" is not exists. Please Add into the list");
			updated = false;
		}
		else {
			index = isExists(phno);
			if(index>=0) {
				System.out.println(phno +" is Already exists."+getContact(phno));
				updated = false;	
			}
			else {
				Contact ct = getContact(name);
				ct.setPhone_number(phno);
				this.contacts.set(index, ct);
				System.out.println("Contact updated : "+ct);
				updated = true;
			}
		}
		return updated;
	}	
	public boolean modify(String name, String newName) {
		//System.out.println("@modify 74");
		boolean updated=false;

		int index = isExists(name);
		if(index<0) {
			System.out.println(name +" is not exists. Please Add into the list");
			updated = false;
		}
		else {
			index = isExists(newName);
			if(index>=0) {
				System.out.println(newName +" is Already exists."+getContact(newName));
				updated = false;	
			}
			else {
				Contact ct = getContact(name);
				ct.setName(newName);
				this.contacts.set(index, ct);
				System.out.println("Contact updated : "+ct);
				updated = true;
			}
		}
		return updated;
	}
	public boolean remove(String name) {
		//System.out.println("@remove 92");
		boolean removed=false;
		int index = isExists(name);
		if(index<0) {
			System.out.println(name +" is not exists.");
			removed = false;
		}		
		else {
			System.out.println("Contact removed : "+getContact(name));
			this.contacts.remove(index);
			removed = true;
		}
		return removed;
	}
	public boolean remove(long phno) {
		//System.out.println("@remove 109");
		boolean rmoved=false;
		int index = isExists(phno);
		if(index<0) {
			System.out.println(phno +" is not exists.");
			rmoved = false;
		}
		else {
			System.out.println("Contact removed : "+getContact(phno));
			this.contacts.remove(index);
			rmoved = true;
		}
		return rmoved;
	}
	private int isExists(String name) {
		//System.out.println("@isExists 126");
		if(!validate(name))
			return -1;
		int index=-1;
		Contact c = null;
		for (int i = 0; i < this.contacts.size(); i++) {
			c = this.contacts.get(i);
			if (name.equals(c.getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	private int isExists( long num) {
		//System.out.println("@isExists 141");
		if(!validate( num))
			return -1;
		int index=-1;
		Contact c = null;
		for (int i = 0; i < this.contacts.size(); i++) {
			c = this.contacts.get(i);
			if (num == c.getPhone_number()) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Contact getContact(String name) {
		//System.out.println("@getContacts 157");
		Contact ct = null;
		if(!validate(name))
			return ct;
		else {
			for (Contact c : this.contacts) {
				if (name.equals(c.getName())) {
					ct = c;
					break;
				}
			}
		}
		return ct;
	}
	public Contact getContact( long num) {
		//System.out.println("@getContacts 172");
		Contact ct = null;
		if(!validate( num))
			return ct;
		else {
			for (Contact c : this.contacts) {
				if (num == c.getPhone_number()) {
					ct = c;
					break;
				}
			}
		}
		return ct;
	}
	private boolean validate(String name) {
		//System.out.println("@validate 187");
		boolean valid = false;
		if(name==null || name.isEmpty() || name.isBlank() ) {
			System.out.println("Name can not be Empty");
		}
		else
			valid = true;
		return valid;
	}
	private boolean validate(long phno) {
		//System.out.println("@validate 197");
		boolean valid = false;
		if(phno < 1000000000)
			System.out.println("Invalid Phone number. Should be 10 digit number.");
		else
			valid = true;
		return valid;
	}	
//	private boolean validate(String name, long phno) {
//		System.out.println("@validate 206");
//		System.out.println("@Validate Name="+name+" PhoneNumber="+phno);
//		boolean valid = false;
//		if(name==null || name.isEmpty() || name.isBlank() ) {
//			System.out.println("Name can not be Empty");
//		}
//		if(phno < 1000000000)
//			System.out.println("Invalid Phone number. Should be 10 digit number.");
//		else
//			valid = true;
//		return valid;
//	}
	public void printContacts() {
		System.out.println("Contacts List....");
		for(Contact c:this.contacts) {
			System.out.println(c);
		}
	}
	
}
