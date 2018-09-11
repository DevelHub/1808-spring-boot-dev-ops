package com.revature.screens;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Weapon;
import com.revature.daos.WeaponDao;
import com.revature.util.AppState;

@Component
public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	@Autowired
	private WeaponDao wd;
	@Autowired
	private AppState state;
	
	@Autowired
	private BuildAWeapon baw;

	public Screen start() {
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1 to build a weapon");
		System.out.println("Enter 2 to view available weapon");
		System.out.println("Enter 3 to view my weapons");
		System.out.println("Enter 4 to sell a weapon");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return baw;
		case "2":
			List<Weapon> weapons = wd.findByUserId(state.getCurrentUser().getId());
			weapons.stream().forEach((each) -> {
				System.out.println(each);
			});
			break;
		case "3":
			System.out.println("selected 3 not yet implemented that screen");
			break;
		case "4":
			System.out.println("selected 4 not yet implemented that screen");
			break;
		default:
			break;
		}

		return this;
	}
}
