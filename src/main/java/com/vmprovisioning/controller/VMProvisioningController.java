package com.vmprovisioning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmprovisioning.dto.ResponseDTO;
import com.vmprovisioning.dto.UsersDTO;
import com.vmprovisioning.dto.VMDTO;
import com.vmprovisioning.service.impl.IVMProvisioningService;

@RestController
public class VMProvisioningController {
	@Autowired
	IVMProvisioningService vmService;
	
	@RequestMapping(value = "/{userId}/requestVM", method = RequestMethod.POST)
    public ResponseEntity<String> requestVM(@Valid @RequestBody VMDTO vm,@PathVariable("userId") Long userId) {
		vmService.createVMRequest(vm,userId);
		 return new ResponseEntity<String>(HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/{vmrequestId}/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateVM(@Valid @RequestBody VMDTO vm,@PathVariable("vmrequestId") Long vmrequestId) {
		vmService.updateVMRequest(vm,vmrequestId);
		 return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value = "/getVMRequests/{userId}", method = RequestMethod.GET )
    public ResponseEntity<ResponseDTO> getVMRequest(@PathVariable("userId") Long userId) {
		
		 return new ResponseEntity<ResponseDTO>(vmService.getAllVMRequests(userId),HttpStatus.OK);
    }

}
