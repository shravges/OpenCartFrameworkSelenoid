package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class LoginPageTest extends BaseTest
{
	
	@Test
	public void checkTitle()
	{
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test
	public void checkNewCustomerHeader()
	{
		boolean newCustomerTitle = loginPage.checkNewCustomerTitle();
		Assert.assertTrue(newCustomerTitle);
	}
	
	@Test
	public void checkContinueButton()
	{
		boolean continueButton = loginPage.checkContinueButton();
		Assert.assertTrue(continueButton);
	}
	
	@Test
	public void checkReturnCustomerHeader()
	{
		boolean returnCustomerTitle = loginPage.checkReturningCustomerTitle();
		Assert.assertTrue(returnCustomerTitle);
	}
	
	@Test
	public void checkLoginButton()
	{
		boolean loginButton = loginPage.checkLoginButton();
		Assert.assertTrue(loginButton);
	}
	
	@Test
	public void checkRHSLinks()
	{
		List<String> expectedLinks = AppConstants.LOGIN_PAGE_EXPECTED_RHSLINKS;
		Collections.sort(expectedLinks);
		
		List<String> RHSlinks = loginPage.checkRHSLinks();
		System.out.println("RHS links on UI" +RHSlinks);
		Assert.assertEquals(RHSlinks, expectedLinks);
	}
	
	@Test
	public void checkHeaderLinks()
	{
		List<String> expectedHeaderList = AppConstants.LOGIN_PAGE_EXPECTED_HEADERLINKS;
		Collections.sort(expectedHeaderList);
		
		List<String> actualHeaderLinks = loginPage.checkHeaderLinks();
		System.out.println("Header links on UI" +actualHeaderLinks);
		Assert.assertEquals(actualHeaderLinks, expectedHeaderList);
	}
	
	
}
