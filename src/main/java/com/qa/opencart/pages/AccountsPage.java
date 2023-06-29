package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. Contructor
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//2. Locators
	private By lnkMyAccount = By.linkText("My Account");
	private By lnkLogout = By.linkText("Logout");
	private By txtbxSearch = By.cssSelector("input[name='search']");
	private By btnSearch = By.cssSelector("button.btn.btn-default.btn-lg");
	
	
	//3. actions
	public boolean checkAccountLink()
	{
		return driver.findElement(lnkMyAccount).isDisplayed();
	}
	
	public boolean checkLogoutLink()
	{
		return driver.findElement(lnkLogout).isDisplayed();
	}

	public ResultsPage enterSearchData(String searchItem)
	{
		eleUtil.doSendKeys(txtbxSearch, searchItem);
		eleUtil.doClick(btnSearch, AppConstants.SHORT_WAIT_DURATION);
		return new ResultsPage(driver);
		
	}
	
	
	
	
}
