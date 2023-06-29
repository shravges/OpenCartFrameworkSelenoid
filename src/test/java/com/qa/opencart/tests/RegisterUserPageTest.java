package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.DataProviderDetails;
import com.qa.opencart.pojo.UserDetails;
import com.qa.opencart.utils.AppConstants;

public class RegisterUserPageTest extends BaseTest
{
	@BeforeClass
	public void setupRegisterPageTest()
	{
		registerUserPage = loginPage.registerUser();
	}
	
	@DataProvider
	public Object[][] newUserData()
	{
		return new Object[][] 
				{
				{new UserDetails("shilpa","ss","1234567890","test123","yes")},
				{new UserDetails("shilpa","ss","1234567890","test567","no")}
				};
	}
	
	/**
	 * This method is taking pojo class as data provider
	 * @param userDetails
	 */
	@Test(dataProvider="newUserData")
	public void createNewUser(UserDetails userDetails)
	{
		String successMessage = registerUserPage.registerUser(userDetails.getFirtName(), userDetails.getLastName(), userDetails.getTelephoneNumber(), userDetails.getPassword(), userDetails.getSubscribe());
		System.out.println("Success message =" +successMessage);
		Assert.assertTrue(successMessage.equalsIgnoreCase(AppConstants.USER_REGISTRATION_SUCCESS_MESSAGE));
	}
	
	
	
	/**
	 * This method is taking excel data as data provider
	 */
	@Test(dataProvider = "getRegistrationData", dataProviderClass=DataProviderDetails.class)
	public void registerUser(String fname, String lname, String phoneNumber, String password, String subscribe)
	{
		String successMessage = registerUserPage.registerUser(fname, lname, phoneNumber, password, subscribe);
		System.out.println("Success message for data through excel =" +successMessage);
		Assert.assertTrue(successMessage.equalsIgnoreCase(AppConstants.USER_REGISTRATION_SUCCESS_MESSAGE));
	}
	
	
	
	
	
	
	
}
