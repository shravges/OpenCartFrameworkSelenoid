package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppConstants 
{
	public static final int SHORT_WAIT_DURATION = 5;
	public static final int MEDIUM_WAIT_DURATION = 10;
	public static final int LONG_WAIT_DURATION = 15;
	
	public static final List<String> LOGIN_PAGE_EXPECTED_RHSLINKS = new ArrayList<String>(Arrays.asList("Login","Register","Forgotten Password","My Account","Address Book","Wish List","Order History","Downloads","Recurring payments","Reward Points","Returns","Transactions","Newsletter"));
	public static final List<String> LOGIN_PAGE_EXPECTED_HEADERLINKS = new ArrayList<String>(Arrays.asList("Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"));

	public static final String USER_REGISTRATION_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	
	public static final String REGISTRATION_DATA_SHEET = "RegistrationData";

}
