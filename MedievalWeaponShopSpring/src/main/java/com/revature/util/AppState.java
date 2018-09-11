package com.revature.util;

import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class AppState {
	private User currentUser;

	private AppState() {

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
