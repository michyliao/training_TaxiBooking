package com.domains;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

public class Booking {
	
	public enum BookingType {
		METER, OUTSTATION, PACKAGE
	}

	private String id;
	private String email;
	private long phone;
	private BookingType bookingType;
	private String pickupPlace;
	private String dropoffPlace;
	private Date pickupTime;
	
	public Booking(){
		super();
	}
	
	public Booking(String email, long phone, BookingType bookingType, String pickupPlace, String dropoffPlace) {
		super();
		this.email = email;
		this.phone = phone;
		this.bookingType = bookingType;
		this.pickupPlace = pickupPlace;
		this.dropoffPlace = dropoffPlace;
		this.id = UUID.randomUUID().toString();
		this.pickupTime = new Date(Calendar.getInstance().getTime().getTime());
	}

	public Booking(String email, long phone, BookingType bookingType, String pickupPlace, String dropoffPlace, Date pickupTime) {
		super();
		this.email = email;
		this.phone = phone;
		this.bookingType = bookingType;
		this.pickupPlace = pickupPlace;
		this.dropoffPlace = dropoffPlace;
		this.id = UUID.randomUUID().toString();
		this.pickupTime = pickupTime;
	}


	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public BookingType getBookingType() {
		return bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
	}

	public String getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	public String getDropoffPlace() {
		return dropoffPlace;
	}

	public void setDropoffPlace(String dropoffPlace) {
		this.dropoffPlace = dropoffPlace;
	}
	
	
	
	
	
}
