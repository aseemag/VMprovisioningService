package com.vmprovisioning.service.impl;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.vmprovisioning.dao.UserDao;
import com.vmprovisioning.dto.ResponseDTO;
import com.vmprovisioning.dto.TokenDTO;
import com.vmprovisioning.dto.UsersDTO;
import com.vmprovisioning.models.Users;
import com.vmprovisioning.util.Constants;

@Service
public class TokenGeneratorService {
	@Autowired
	UserDao userDao;

	public ResponseDTO getToken(@Valid UsersDTO userDto)
	{  Users user=userDao.getUserByName(userDto.getName());
		String token = JWT.create().withClaim("name", user.getName())
    .withExpiresAt(new Date(System.currentTimeMillis() +Constants.EXPIRATION_TIME))
    .sign(HMAC512(Constants.SECRET.getBytes()));
		TokenDTO tokendto=new TokenDTO();
		tokendto.setToken(Constants.TOKEN_PREFIX + token);
		tokendto.setUsername(user.getName());
     
		return createResponseDTO(tokendto);
	}

	private ResponseDTO createResponseDTO(TokenDTO tokendto) {
		ResponseDTO dto=new ResponseDTO();
		dto.setSuccess(true);
		dto.setData(tokendto);
		dto.setStatusCode(HttpStatus.OK.value());
		return dto;
	}

}
