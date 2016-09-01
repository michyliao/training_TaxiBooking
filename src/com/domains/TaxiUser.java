package com.domains;

import java.util.UUID;

public class TaxiUser {

	private String id;
	private String email;
	private String password;
	private long phonenumber;
	private String city;
	
	public TaxiUser(){
		super();
	}

	public TaxiUser(String email, String password, long phonenumber, String city) {
		super();
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.city = city;
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
}
