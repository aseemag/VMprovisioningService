package com.vmprovisioning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmprovisioning.dto.ResponseDTO;
import com.vmprovisioning.dto.UsersDTO;
import com.vmprovisioning.service.impl.TokenGeneratorService;

@RestController
public class TokenGeneratorController {
	@Autowired
	TokenGeneratorService tokenService;
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> getToken(@Valid @RequestBody UsersDTO user) {
        
        return new ResponseEntity<ResponseDTO>(tokenService.getToken(user),HttpStatus.OK);
    }

}
