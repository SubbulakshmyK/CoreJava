package demos.myJava.bankApp;

import java.util.ArrayList;

public class Bank {

	private String Name;
	private ArrayList<Branch> branches;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<Branch> getBranches() {
		return branches;
	}
	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}
	public Bank(String name) {
		super();
		Name = name;
		this.branches = new ArrayList<Branch>();
	}
	public void addBranch(String branch) {
		int index = getPosition(branch);
		if(index<0) {
			Branch br = new Branch(branch);
			this.branches.add(br);
			System.out.println("Branch added successfully...");
		}
		else
			System.out.println("Branch already Exists...");
	}
	public Bank() {
		super();
	}
	@Override
	public String toString() {
		return "Bank [Name=" + Name + ", branches=" + branches + "]";
	}
	
	private int getPosition(String branch) {
		int index =-1;
		for(int i=0; i<this.branches.size(); i++) {
			if(branch.equals(this.branches.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	public Branch getBranch(String branchName) {
		Branch branch = null;
		for(int i=0; i<this.branches.size(); i++) {
			if(branchName.equals(this.branches.get(i).getName())) {
				branch = this.branches.get(i);
				break;
			}
		}
		if(branch == null)
			System.out.println("Branch not exists..");
		return branch;
	}
}
