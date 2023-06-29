package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.DataProviderDetails;

public class SearchPageTest extends BaseTest
{
	@BeforeClass
	public void searchSetup() throws InterruptedException
	{
		accountsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		
	@Test(dataProvider="ProductData", dataProviderClass=DataProviderDetails.class)
	public void enterProductToBesearched(String productName)
	{
		resultsPage = accountsPage.enterSearchData(productName);
		boolean ifHeaderPresent = resultsPage.checkResultHeaderPresent();
		Assert.assertTrue(ifHeaderPresent);
		System.out.println("Search done for " +productName);
	}
	
	@Test(dataProvider="ProductData", dataProviderClass=DataProviderDetails.class)
	public void checkProductCount(String productName)
	{
		resultsPage = accountsPage.enterSearchData(productName);
		int resultCount = resultsPage.checkSearchResultCount();
		Assert.assertTrue(resultCount > 0, "No search results shown for given product");
	}
	
		
	@Test(dataProvider="ProductSubProductData", dataProviderClass=DataProviderDetails.class)
	public void selectProduct(String productName, String subProductName)
	{
		resultsPage = accountsPage.enterSearchData(productName);
		productInfoPage = resultsPage.selectProduct(subProductName);
		boolean ifProductDetailsDisplayed = productInfoPage.checkProductName(subProductName);
		Assert.assertTrue(ifProductDetailsDisplayed);
	}
	
		
	@Test(dataProvider="ProductDetails", dataProviderClass=DataProviderDetails.class)
	public void checkProductImagesCount(String productName, String subProductName, int productImageCount)
	{
		resultsPage = accountsPage.enterSearchData(productName);
		productInfoPage = resultsPage.selectProduct(subProductName);
		int productImages = productInfoPage.checkProductImages();
		Assert.assertEquals(productImages,productImageCount);
	}
	
	

}
