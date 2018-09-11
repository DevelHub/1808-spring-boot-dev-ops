package com.revature.daos;

import java.util.List;

import com.revature.beans.Weapon;

public interface WeaponDao {
	public static final WeaponDao currentWeaponDao = new WeaponDaoJdbc();
	
	int createWeapon(Weapon w);

	List<Weapon> findByUserId(int userId);
	
}
