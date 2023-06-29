package com.qa.opencart.pages;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage
{
	private WebDriver driver;
	private ElementUtil eleUtil;
		
	//1. Contructor
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//2. by locators
	private By divTotalProducts = By.cssSelector("div.product-layout.product-grid");
	private By headerSearchItems = By.xpath("//h2[text()='Products meeting the search criteria']");
		
	//3. actions
	public boolean checkResultHeaderPresent()
	{
		return eleUtil.checkElementIsDisplayed(headerSearchItems);
	}
	
	public int checkSearchResultCount()
	{
		return eleUtil.getElementsCount(divTotalProducts);
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		By productLink = By.linkText(productName);
		eleUtil.doClick(productLink);
		return new ProductInfoPage(driver);
	}
	
	
	
	
}
