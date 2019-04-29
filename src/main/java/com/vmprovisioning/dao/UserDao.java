package com.vmprovisioning.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmprovisioning.models.Users;
import com.vmprovisioning.models.VMProvisioning;
import com.vmprovisioning.repository.UserRepository;

@Component
public class UserDao {
	@Autowired
	UserRepository userRepo;
	
	public Users registerUser(Users user)
	{
		return userRepo.save(user);
	}

	public List<Users> getUser(String emailAddress, Long mobileNo) {
		// TODO Auto-generated method stub
		return userRepo.findUsersByMobileNoOrEmail(mobileNo, emailAddress);
	}

	public Users findUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepo.findUserByUserId(userId);
	}

	public Users getUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByName(name);
	}

	

}
