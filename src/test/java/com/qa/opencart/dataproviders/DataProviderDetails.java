package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtils;

public class DataProviderDetails
{
	@DataProvider(name="ProductData")
	public Object[][] getProductName()
	{
		return new Object[][]  {
				{"Macbook"},
				{"Samsung"},
				{"iMac"}
		};
	}
	
	@DataProvider(name ="ProductSubProductData")
	public Object[][] getProductToSelect()
	{
		return new Object[][] {
			{"Macbook","MacBook Pro"},
			{"iMac","iMac"}
		};
		
	}
	
	@DataProvider(name="ProductDetails")
	public Object[][] getProductDetails()
	{
		return new Object[][]
			{
			{"Macbook","MacBook Pro",4},
			{"iMac","iMac",3}
			};
	}
	
	//this data provider is taking data from excel
	@DataProvider(name="getRegistrationData")
	public Object[][] getRegistrationData()
	{
		Object[][] registrationData = ExcelUtils.getTestDataFromExcel(AppConstants.REGISTRATION_DATA_SHEET);
		return registrationData;
		
	}
	

}
