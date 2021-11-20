package com.mobileapp.model;

public class Mobile {

	private String model;
	private String brand;
	private String storage;
	private String os;
	private double price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String model, String brand, String storage, String os, double price) {
		super();
		this.model = model;
		this.brand = brand;
		this.storage = storage;
		this.os = os;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [model=" + model + ", brand=" + brand + ", storage=" + storage + ", os=" + os + ", price="
				+ price + "]";
	}
	
}
