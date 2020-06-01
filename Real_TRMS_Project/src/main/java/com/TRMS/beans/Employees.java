package com.TRMS.beans;

public class Employees {

	private int empID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	private float amtAvail;
	private String department;
	private String branch;
	
	public Employees() {
		super();
	}
	
	

	public Employees(int empID, String username, String password, String firstName, String lastName, String email,
			String type, float amtAvail, String department, String branch) {
		super();
		this.empID = empID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.department = department;
		this.branch = branch;
		this.amtAvail = amtAvail;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getBranch() {
		return branch;
	}



	public void setEmpID(int empID) {
		this.empID = empID;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public int getEmpID() {
		return empID;
	}


	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}

	public String getType() {
		return type;
	}

	public float getAmtAvail() {
		return amtAvail;
	}

	public void setAmtAvail(float amtAvail) {
		this.amtAvail = amtAvail;
	}

	@Override
	public String toString() {
		return "Employees [empID=" + empID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", type=" + type + ", department="
				+ department + ", branch=" + branch + ", amtAvail=" + amtAvail + "]";
	}

	
}
