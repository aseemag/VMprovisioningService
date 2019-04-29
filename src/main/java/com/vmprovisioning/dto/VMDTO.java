package com.vmprovisioning.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

public class VMDTO {
	
	private String os;
	private String ram;
	private String hardDisk;
	@Min(value = 1,message="No of cores cannot be less than 1")
	@NotNull(message="No of cores cannot be null")
	private Integer cpuCores;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public Integer getCpuCores() {
		return cpuCores;
	}
	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}
	
	
	
	

}
