package com.sp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.api.domain.User;
import com.sp.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repositry;

	@Override
	public boolean validateUser(User user) {
		User userEntity =repositry.findByUserId(user.getUserId().toLowerCase());
		if(userEntity!=null && user.getPassword().equals(userEntity.getPassword())) {
			return true;
		}
		return false;
	}

}
