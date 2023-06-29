package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;

public class AccountsPageTest extends BaseTest
{
	AccountsPage accountsPage;
	
	@BeforeClass
	public void getAccountPageObject() throws InterruptedException
	{
		accountsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void testMyAccountLink()
	{
		boolean lnkPresent = accountsPage.checkAccountLink();
		Assert.assertTrue(lnkPresent);
	}
	
	@Test
	public void testLogoutLink()
	{
		boolean lnkLogoutPresent = accountsPage.checkLogoutLink();
		Assert.assertTrue(lnkLogoutPresent);
	}

}
