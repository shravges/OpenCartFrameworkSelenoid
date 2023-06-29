package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterUserPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest
{
	
	WebDriver driver = null;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterUserPage registerUserPage;
	protected SoftAssert softAssert;
	
	protected Properties prop;
	protected DriverFactory driverFactory;
	
	@Parameters({"browser","browserversion"})
	@BeforeTest
	public void setup(String browserName, String browserVersion)
	{
		System.out.println("Browser received from testng file = " +browserName);
		softAssert = new SoftAssert();
		driverFactory = new DriverFactory();
		prop = driverFactory.initializeProperties();
		
		if(browserName != null)
		{
			System.out.println("Browser coming from testng file = " +browserName);
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
			
		}
		
		driver = driverFactory.intializeDriver(prop);
		loginPage = new LoginPage(driver);
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
