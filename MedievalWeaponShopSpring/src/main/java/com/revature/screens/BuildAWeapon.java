package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.beans.Weapon;
import com.revature.daos.WeaponDao;
import com.revature.util.AppState;

@Component
public class BuildAWeapon implements Screen {
	@Autowired
	private AppState state;
	private Logger log = Logger.getRootLogger();
	private Scanner scan = new Scanner(System.in);
	@Autowired
	private WeaponDao wd;
	
	@Autowired
	private LoginScreen ls;
	@Autowired
	private HomeScreen hs;

	@Override
	public Screen start() {
		User currentUser = state.getCurrentUser();
		if (currentUser == null) {
			return ls;
		}
		try {
			Weapon w = new Weapon();
			System.out.println("How many blades do you want?");
			String numBlades = scan.nextLine();
			w.setNumberBlades(Integer.valueOf(numBlades));
			System.out.println("How heavy?");
			String weight = scan.nextLine();
			w.setWeight(Double.valueOf(weight));
			System.out.println("What type?");
			w.setWeaponType(scan.nextLine());
			w.setUserId(currentUser.getId());
			int weaponId = wd.createWeapon(w);
			if (weaponId == 0) {
				log.error("failed to create weapon");
				return ls;
			}
			w.setWeaponId(weaponId);
			log.info("created weapon" + w);

		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return hs;
	}
}
