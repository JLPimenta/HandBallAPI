package com.handballCamp.model;

public class Player {
	private String name;
	private String birthDate;
	private char gender;
	private Double height;
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	
	public Player(String name, String birthDate, char gender, Double height, int number) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.height = height;
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public void setHeight(Double height) {
		this.height = height;
	}
}