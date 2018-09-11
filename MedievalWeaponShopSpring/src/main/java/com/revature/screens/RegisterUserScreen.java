package com.revature.screens;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.daos.UserDao;

@Component
public class RegisterUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Autowired
	private UserDao ud;
	
	@Autowired
	private LoginScreen ls;

	@Override
	public Screen start() {
		User u = new User();
		System.out.println("Enter new username");
		u.setUsername(scan.nextLine());
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());
		System.out.println("Enter age");
		String age = scan.nextLine();

		try {
			u.setAge(Integer.valueOf(age));
			ud.createUser(u);

		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return ls;
	}

}
