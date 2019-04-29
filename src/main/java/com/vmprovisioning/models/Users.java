package com.vmprovisioning.models;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "name",nullable=false)
    private String name;
	
	@Column(name = "email_address",nullable=false)
    private String email;
	
	@Column(name = "password",nullable=false)
    private String password;
	
	@Column(name = "mobile_no",nullable=false,columnDefinition="bigint default 0")
    private long mobileNo;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<VMProvisioning> vmProvisioningRequest;
	
	

	

	public Set<VMProvisioning> getVmProvisioningRequest() {
		return vmProvisioningRequest;
	}

	public void setVmProvisioningRequest(Set<VMProvisioning> vmProvisioningRequest) {
		this.vmProvisioningRequest = vmProvisioningRequest;
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
