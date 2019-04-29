package com.vmprovisioning.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vmprovisioning.dao.UserDao;
import com.vmprovisioning.dto.UsersDTO;
import com.vmprovisioning.exceptions.ValidationException;
import com.vmprovisioning.models.Users;

@Service
public class RegistrationService {
	private static Logger log=LoggerFactory.getLogger(RegistrationService.class);
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDao userDao;

	public String registerUser(UsersDTO userDTO)  {
		Users userExisting=userDao.getUserByName(userDTO.getName());
		if(null!=userExisting)
		{
			log.error("UserName already Exist");
			throw new ValidationException("Username already Exist");
		}
		List<Users> existingUser=userDao.getUser(userDTO.getEmailAddress(),Long.parseLong(userDTO.getMobileNo()));
		if(null != existingUser && existingUser.size()>0)
		{
			log.error("Email Address Or Mobile no already Exist");
			throw new ValidationException("Email Address Or Mobile no already Exist");
		}
		Users user=new Users();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmailAddress());
		user.setMobileNo(Long.parseLong(userDTO.getMobileNo()));
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		user= userDao.registerUser(user);
		return "";
	}

}
