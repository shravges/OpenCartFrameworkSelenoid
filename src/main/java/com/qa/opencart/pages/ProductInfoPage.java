package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	private HashMap<String,String> productInfo = new HashMap<String,String>();
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	By imgProductImages = By.cssSelector("ul.thumbnails a");
	private By productMetadata = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	//3. actions
	public boolean checkProductName(String productName)
	{
		By headerProductName = By.xpath("//h1[text()='"+productName+"']");
		return eleUtil.checkElementIsDisplayed(headerProductName);
	}
	
	public int checkProductImages()
	{
		return eleUtil.getElementsCount(imgProductImages);
	}
	
	public HashMap<String, String> productDetails()
	{
		getProductMetaData();
		getProductPriceData();
		return productInfo;
	}
	
	private void getProductMetaData()
	{
		List<WebElement> metadataItems = eleUtil.getElements(productMetadata);
		for(WebElement e: metadataItems)
		{
			String text = e.getText();
			String[] data = text.split(":");
			productInfo.put(data[0].trim(), data[1].trim());
		}
	}
	
	private void getProductPriceData()
	{
		List<WebElement> priceItems = eleUtil.getElements(productPriceData);
		productInfo.put("productprice", priceItems.get(0).getText().trim());
		productInfo.put("producttaxprice", priceItems.get(1).getText().split(":")[1].trim());
	}
}
