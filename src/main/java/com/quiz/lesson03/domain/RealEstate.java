package com.quiz.lesson03.domain;

import java.time.LocalDateTime;

// Java bean
public class RealEstate {

	// field
	private int id;
	private int realtorId;
	private String address;
	private int area;
	private String type;
	private int price;
	private Integer rentPrice; // !!null이 들어올 수 있음
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// getter, setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRealtorId() {
		return realtorId;
	}
	public void setRealtorId(int realtorId) {
		this.realtorId = realtorId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
