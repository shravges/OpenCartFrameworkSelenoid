package com.qa.opencart.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ResultsPageTest extends BaseTest
{
	
	@BeforeClass
	public void setupResultsPageTest() throws InterruptedException
	{
		accountsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	//Brand=Apple, Availability=In Stock, producttaxprice=$2,000.00, Product Code=Product 18, Reward Points=800, productprice=$2,000.00
	@Test
	public void checkProductMetaData()
	{
		Map<String,String> productDataDetails = new HashMap<String,String>();
		resultsPage = accountsPage.enterSearchData("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		productDataDetails = productInfoPage.productDetails();
		System.out.println(productDataDetails);
		softAssert.assertEquals(productDataDetails.get("Brand"), "Apple");
		softAssert.assertEquals(productDataDetails.get("Availability"), "In Stock");
		softAssert.assertEquals(productDataDetails.get("producttaxprice"), "$2,000.00");
		softAssert.assertEquals(productDataDetails.get("Product Code"), "Product 18");
		softAssert.assertEquals(productDataDetails.get("Reward Points"), "800");
		softAssert.assertEquals(productDataDetails.get("productprice"), "$2,000.00");
		softAssert.assertAll();
	}
	
	
	
}
