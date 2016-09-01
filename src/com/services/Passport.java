package com.services;

import com.domains.TaxiUser;
import com.managers.TaxiUserManager;

public class Passport {

	TaxiUserManager manager;

	public Passport() {
		super();
		manager = new TaxiUserManager();
	}

	public TaxiUser createUser(String email, String password, Long phone, String city) {
		TaxiUser user = new TaxiUser(email, password, phone, city);

		if (manager.find(user.getId(), email) == null) {
			manager.create(user);
		} else {
			// Duplicate values not allow
			user = null;
		}
		return user;
	}

	public boolean validate(String email, String password, String city) {
		TaxiUser user = manager.find("", email);
		
		if (user != null) {
			return true;
		}
		return false;
	}

	public TaxiUser getUser(String email){
		return manager.find("", email);
	}
	
}
