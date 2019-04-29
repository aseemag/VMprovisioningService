package com.vmprovisioning.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vmprovisioning.util.Constants;

public class UsersDTO {
	@NotNull(message="Name cannot be null")
	@Pattern(regexp=Constants.USERNAME_REGEX,message="Name should have 3 to 15 characters with any lower case character, digit or special symbol “_-” only")
	private String name;
	@NotNull(message="Password cannot be null")
	private String password;
	@NotNull(message="EmailAddress cannot be null")
	@Pattern(regexp=Constants.EMAIL_REGEX,message="Invalid Email Address")
	private String emailAddress;
	@NotNull(message="MobileNo cannot be null")
	@Pattern(regexp=Constants.MOBILE_REGEX,message="Enter a 10 digit mobile no")
	private String mobileNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	
	
	

}
