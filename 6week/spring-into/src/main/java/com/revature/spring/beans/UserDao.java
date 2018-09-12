package com.revature.spring.beans;

public class UserDao {
	
	private String myField;
	
	public void daoMethod() {
		System.out.println("Dao Method called");
		System.out.println("My field is: " + myField);
	}

	public String getMyField() {
		return myField;
	}

	public void setMyField(String myField) {
		this.myField = myField;
	}
	
	
}
