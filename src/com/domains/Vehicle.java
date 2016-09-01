package com.domains;

public class Vehicle {
	
	private String id;
	private String type;
	private String type_full;
	private Double minKm;
	private Double addCharge;
	private Double wtgCharge;
	
	public Vehicle() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType_full() {
		return type_full;
	}

	public void setType_full(String type_full) {
		this.type_full = type_full;
	}

	public Double getMinKm() {
		return minKm;
	}

	public void setMinKm(Double minKm) {
		this.minKm = minKm;
	}

	public Double getAddCharge() {
		return addCharge;
	}

	public void setAddCharge(Double addCharge) {
		this.addCharge = addCharge;
	}

	public Double getWtgCharge() {
		return wtgCharge;
	}

	public void setWtgCharge(Double wtgCharge) {
		this.wtgCharge = wtgCharge;
	}
	
}
