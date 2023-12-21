package com.example.restservice.model;

public class Consumer {
	int userid;
	String email;
	String password;
	String firstname;
	String lastname;
	
	public Consumer(int userid, String email, String firstname, String lastname, String password) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	
	public Consumer(String email, String firstname, String lastname, String password) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public Consumer(int userid, String email, String firstname, String lastname) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Consumer(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
