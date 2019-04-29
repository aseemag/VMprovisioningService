package com.vmprovisioning.service.impl;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.vmprovisioning.dto.ResponseDTO;
import com.vmprovisioning.dto.VMDTO;

public interface IVMProvisioningService {

	String createVMRequest(@Valid VMDTO vm, Long userId);

	void updateVMRequest(@Valid VMDTO vm, Long vmrequestId);

	ResponseDTO getAllVMRequests(Long userId);

}
