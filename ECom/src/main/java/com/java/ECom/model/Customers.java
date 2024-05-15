package com.java.ECom.model;

public class Customers {

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	//private String phoneNumber;
	private String address;
	private String passWord;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public String getPhone() {
		return phoneNumber;
	}
	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	*/
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	public Customers() {
		
	}
	public Customers(int customerId, String firstName, String lastName, String email,
			String address, String passWord) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.phoneNumber = phoneNumber;
		this.address = address;
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address=" + address + ", passWord="
				+ passWord + "]";
	}
	
	
	
	
}
