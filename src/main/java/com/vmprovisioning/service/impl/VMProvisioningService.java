package com.vmprovisioning.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vmprovisioning.dao.UserDao;
import com.vmprovisioning.dao.VMProvisioningDao;
import com.vmprovisioning.dto.ResponseDTO;
import com.vmprovisioning.dto.VMDTO;
import com.vmprovisioning.exceptions.ValidationException;
import com.vmprovisioning.models.Users;
import com.vmprovisioning.models.VMProvisioning;

@Service
public class VMProvisioningService  implements IVMProvisioningService{
	private static Logger log=LoggerFactory.getLogger(VMProvisioningService.class);
	@Autowired
	UserDao userDao;
	
	@Autowired
	VMProvisioningDao vmDao;

	@Override
	public String createVMRequest(VMDTO vm, Long userId) {
		VMProvisioning vmpro=new VMProvisioning();
		vmpro.setCpuCores(vm.getCpuCores());
		vmpro.setHardDisk(vm.getHardDisk());
		vmpro.setRam(vm.getRam());
		vmpro.setOs(vm.getOs());
		Users user=userDao.findUserById(userId);
		vmpro.setUser(user);
		user.getVmProvisioningRequest().add(vmpro);
		vmDao.save(vmpro);
		
		return null;
	}

	@Override
	public void updateVMRequest(@Valid VMDTO vm, Long vmrequestId) {
		// TODO Auto-generated method stub
		
		VMProvisioning vmpro=vmDao.findVMRequest(vmrequestId);
		if(null == vmpro)
		{
			log.error("VMRequest Id does not exist");
			throw new ValidationException("VMRequest Id does not exist");
		}
		vmpro.setCpuCores(vm.getCpuCores());
		vmpro.setHardDisk(vm.getHardDisk());
		vmpro.setRam(vm.getRam());
		vmpro.setOs(vm.getOs());
		Users user=userDao.findUserById(vm.getUserId());
		if(null == user)
		{
			log.error("Error Updating Request as User does not exist");
			throw new ValidationException("Error Updating Request as User does not exist");
		}
		vmpro.setUser(user);
		user.getVmProvisioningRequest().add(vmpro);
		vmDao.save(vmpro);
		
		
	}

	@Override
	public ResponseDTO getAllVMRequests(Long userId) {
		
		Users user=userDao.findUserById(userId);
		if(null == user)
		{
			log.error("User does not exist");
			throw new ValidationException("User does not exist");
		}
		Set<VMProvisioning> vmsList=user.getVmProvisioningRequest();
		
		Set<VMDTO> vmDtoList=new HashSet<>();
		
		convertEntityToDTo(vmsList,vmDtoList);
		
		return buildApiResponse(vmDtoList);
	}

	private void convertEntityToDTo(Set<VMProvisioning> vmsList, Set<VMDTO> vmDtoList) {
		// TODO Auto-generated method stub
		for(VMProvisioning vm:vmsList)
		{
			VMDTO vmDto=new VMDTO();
			vmDto.setCpuCores(vm.getCpuCores());
			vmDto.setHardDisk(vm.getHardDisk());
			vmDto.setOs(vm.getOs());
			vmDto.setRam(vm.getRam());
			vmDtoList.add(vmDto);
		}
		
	}

	private ResponseDTO buildApiResponse(Set<VMDTO> vmDtoList) {
		ResponseDTO res=new ResponseDTO();
		res.setData(vmDtoList);
		res.setSuccess(true);
		res.setStatusCode(HttpStatus.OK.value());
		return res;
	}

}
