package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Weapon;
import com.revature.util.ConnectionUtil;

@Repository
public class WeaponDaoJdbc implements WeaponDao {
	private Logger log = Logger.getRootLogger();

	@Autowired
	private ConnectionUtil cu;

	@Override
	public int createWeapon(Weapon w) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO weapons (number_blades, weight, weapon_type, user_id) VALUES (?,?,?,?)",
					new String[] { "weapon_id" });
			ps.setInt(1, w.getNumberBlades());
			ps.setDouble(2, w.getWeight());
			ps.setString(3, w.getWeaponType());
			ps.setInt(4, w.getUserId());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				log.trace("generated weapon id is" + rs.getInt("weapon_id"));
				return rs.getInt("weapon_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
		return 0;
	}

	@Override
	public List<Weapon> findByUserId(int userId) {
		try (Connection conn = cu.getConnection()) {
			List<Weapon> weapons = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM weapons WHERE user_id=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Weapon w = new Weapon();
				w.setNumberBlades(rs.getInt("number_blades"));
				w.setUserId(rs.getInt("user_id"));
				w.setWeaponId(rs.getInt("weapon_id"));
				w.setWeaponType(rs.getString("weapon_type"));
				w.setWeight(rs.getDouble("weight"));
				weapons.add(w);
			}
			return weapons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
