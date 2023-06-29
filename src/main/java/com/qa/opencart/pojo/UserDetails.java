package com.qa.opencart.pojo;

public class UserDetails 
{
	private String firtName;
	private String lastName;
	private String telephoneNumber;
	private String password;
	private String subscribe;
	
	public UserDetails(String firtName, String lastName, String telephoneNumber, String password,String subscribe) 
	{
		this.firtName = firtName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.password = password;
		this.subscribe = subscribe;
	}

	public String getFirtName() {
		return firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	@Override
	public String toString() {
		return "UserDetails [firtName=" + firtName + ", lastName=" + lastName + ", telephoneNumber=" + telephoneNumber
				+ ", password=" + password + ", subscribe=" + subscribe + "]";
	}

	
	
	
	
	

}
