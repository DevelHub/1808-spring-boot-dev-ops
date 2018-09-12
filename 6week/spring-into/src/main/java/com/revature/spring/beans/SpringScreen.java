package com.revature.spring.beans;

public class SpringScreen {

	private UserDao ud;

	public void run() {
		System.out.println("starting");
		ud.daoMethod();
		System.out.println("I ran");
	}

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
