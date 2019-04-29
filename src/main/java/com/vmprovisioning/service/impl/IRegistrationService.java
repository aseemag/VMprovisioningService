package com.vmprovisioning.service.impl;

import javax.validation.Valid;

import com.vmprovisioning.dto.UsersDTO;

public interface IRegistrationService {

	String registerUser(@Valid UsersDTO user);

}
