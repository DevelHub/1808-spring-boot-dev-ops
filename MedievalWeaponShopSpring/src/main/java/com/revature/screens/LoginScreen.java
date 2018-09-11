package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

// if you want you can give them a name to retreive it directly from the application context
@Component("LoginScreen")
public class LoginScreen implements Screen {
	@Autowired
	private AppState state;
	private Scanner scan = new Scanner(System.in);
	@Autowired
	private UserDao ud;
	private Logger log = Logger.getRootLogger();
	
	@Autowired
	private RegisterUserScreen rus;
	@Autowired
	private HomeScreen hs;

	@Override
	public Screen start() {
		log.debug("started login screen");
		System.out.println("Enter Username or type Register to sign up: ");
		String username = scan.nextLine();
		log.trace("username = " + username);
		if ("register".equalsIgnoreCase(username)) {
			return rus;
		}

		System.out.println("Enter Password: ");
		String password = scan.nextLine();

		log.debug("received users credentials");
		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			state.setCurrentUser(currentUser);
			log.info("user succefully logged in");
			log.info("welcome" + currentUser);
			return hs;
		}

		System.out.println("unable to login");
		return this;
	}

}
