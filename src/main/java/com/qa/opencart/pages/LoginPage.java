package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. Contructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//2. By locators
	private By titleNewCustomer = By.xpath("//h2[text()='New Customer']");
	private By btnContinue = By.xpath("//a[text()='Continue']");
	private By titleReturningCustomer = By.xpath("//h2[text()='Returning Customer']");
	private By btnLogin = By.cssSelector("input[type='submit']");
	private By lnkRHSLinks = By.cssSelector("div.list-group a");
	private By linkHeaderKLinks = By.cssSelector("ul.nav.navbar-nav>li");
	private By txtbxUserName = By.cssSelector("input#input-email");
	private By txtbxPassword = By.cssSelector("input#input-password");
	private By lnkRegister = By.linkText("Register");
		
	//3. actions
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean checkNewCustomerTitle()
	{
		return eleUtil.checkElementIsDisplayed(titleNewCustomer);
	}
	
	public boolean checkContinueButton()
	{
		return eleUtil.checkElementIsDisplayed(btnContinue);
	}
	
	public boolean checkReturningCustomerTitle()
	{
		return eleUtil.checkElementIsDisplayed(titleReturningCustomer);
	}
	
	public boolean checkLoginButton()
	{
		return eleUtil.checkElementIsDisplayed(btnLogin);
	}
	
	public List<String> checkRHSLinks()
	{
		List<WebElement> RHSLinks = eleUtil.waitForElementsVisible(lnkRHSLinks, AppConstants.SHORT_WAIT_DURATION);
		List<String> actualLinks = new ArrayList<String>();
		
		for(WebElement e:RHSLinks)
		{
			String text = e.getText();
			actualLinks.add(text);
		}
		
		Collections.sort(actualLinks);
		return actualLinks;
		
	}
	
	public List<String> checkHeaderLinks()
	{
		List<WebElement> headers = eleUtil.waitForElementsVisible(linkHeaderKLinks, AppConstants.MEDIUM_WAIT_DURATION);
		List<String> actualHeaderList = new ArrayList<String>();
		
		for(WebElement e:headers)
		{
			actualHeaderList.add(e.getText());
		}
		
		Collections.sort(actualHeaderList);
		return actualHeaderList;
	}
	
	public AccountsPage login(String username, String password) throws InterruptedException
	{
		eleUtil.waitForElementVisible(txtbxUserName, AppConstants.MEDIUM_WAIT_DURATION).sendKeys(username);
		eleUtil.waitForElementVisible(txtbxPassword, AppConstants.MEDIUM_WAIT_DURATION).sendKeys(password);
		eleUtil.doClick(btnLogin);
		return new AccountsPage(driver);
	}
	

	public RegisterUserPage registerUser() {
		eleUtil.doClick(lnkRegister);
		return new RegisterUserPage(driver);
	}
	
	
	
	
	
	
	
}
