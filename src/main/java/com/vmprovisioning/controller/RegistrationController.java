package com.vmprovisioning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmprovisioning.dto.UsersDTO;
import com.vmprovisioning.service.impl.IRegistrationService;
import com.vmprovisioning.service.impl.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	IRegistrationService registrationService;
	
	@RequestMapping(value = "/register/users", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@Valid @RequestBody UsersDTO user) {
        registrationService.registerUser(user);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
