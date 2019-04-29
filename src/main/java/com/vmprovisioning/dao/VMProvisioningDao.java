package com.vmprovisioning.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmprovisioning.models.VMProvisioning;
import com.vmprovisioning.repository.VMRepository;

@Component
public class VMProvisioningDao {

	@Autowired
	VMRepository vmRepo;
	public void save(VMProvisioning vmpro) {
		vmRepo.save(vmpro);
		
	}
	public VMProvisioning findVMRequest(Long vmrequestId) {
		// TODO Auto-generated method stub
		return vmRepo.getById(vmrequestId);
	}
	

}
