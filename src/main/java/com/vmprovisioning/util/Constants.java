package com.vmprovisioning.util;

public class Constants {
	
	    public static final String SECRET = "VMProvisioning";
	    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	    public static final String TOKEN_PREFIX = "Bearer ";
	    public static final String HEADER_STRING = "Authorization";
	    public static final String SIGN_UP_URL = "/register/users";
	    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    public static final String PASSWORD_REGEX= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	    public static final String USERNAME_REGEX = "^[a-z][a-z0-9_-]{3,15}$";
	    public static final String MOBILE_REGEX = "\\d{10}";
	

}
