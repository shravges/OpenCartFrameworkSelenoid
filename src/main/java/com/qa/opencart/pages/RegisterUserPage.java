package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegisterUserPage
{
	WebDriver driver;
	ElementUtil eleUtil;
	
	//1. constructor
	public RegisterUserPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	
	//2. By locators
	private By txtbxFirstName = By.id("input-firstname");
	private By txtbxLastName = By.id("input-lastname");
	private By txtbxEmail = By.id("input-email");
	private By txtbxTelephone = By.id("input-telephone");
	private By txtbxPassword = By.id("input-password");
	private By txtbxConfirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//input[@name='newsletter' and @value=1]");
	private By subscribeNo = By.xpath("//input[@name='newsletter' and @value=0]");
	private By chcbxAgree = By.xpath("//input[@name='agree']");
	private By btnContinue= By.xpath("//input[@type='submit']");
	private By successMessage = By.tagName("h1");
	private By lnkLogOut = By.linkText("Logout");
	private By lnkRegister = By.linkText("Register");
	
	public String registerUser(String fname, String lname, String telephone, String password, String subscribe)
	{
		eleUtil.doSendKeys(txtbxFirstName, fname);
		eleUtil.doSendKeys(txtbxLastName, lname);
		eleUtil.doSendKeys(txtbxEmail, generateEmailId());
		eleUtil.doSendKeys(txtbxTelephone, telephone);
		eleUtil.doSendKeys(txtbxPassword, password);
		eleUtil.doSendKeys(txtbxConfirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("yes"))
		{
			eleUtil.doClick(subscribeYes);
		}
		else
		{
			eleUtil.doClick(subscribeNo);
		}
		
		eleUtil.doClick(chcbxAgree);
		eleUtil.doClick(btnContinue);
		
		String message = eleUtil.doGetElementText(successMessage);
		
		eleUtil.doClick(lnkLogOut);
		eleUtil.doClick(lnkRegister);
		
		return message;
	}
		
	private static String generateEmailId()
	{
		return "testautomation" + System.currentTimeMillis() + "@gmail.com";
	}
	
	
	
	

}
