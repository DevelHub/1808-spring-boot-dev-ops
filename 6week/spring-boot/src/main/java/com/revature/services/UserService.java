package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.AppUser;
import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo ur;

	public List<AppUser> findAll() {
		return ur.findAll();
	}

	public AppUser findOne(int id) {
		return ur.findById(id).get();
	}
	
	public AppUser login(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}

	public List<AppUser> findByMoviesId(int id) {
		return ur.findByMoviesId(id);
	}
}
