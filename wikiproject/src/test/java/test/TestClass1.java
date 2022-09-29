package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM_Classes.HomePage;
import POM_Classes.SearchResult;
import base.BaseClass;
import utils.UtilityClass;



public class TestClass1 extends BaseClass
{

	HomePage homePage;
	SearchResult searchResult;
	int TestID;
	
	
	@BeforeTest
	@Parameters("browserName")
	public void openBrowser(String browserName )
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			launchChromeBrowser();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMObject()
	{
		
		homePage=new HomePage(driver);
		searchResult=new SearchResult(driver);
		
	}
	
	@BeforeMethod
	public void searchMovieByName() throws IOException
	{
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		 
		homePage.clickOnTime_search(UtilityClass.actiTimeData("MovieName"));
		homePage.clickOn_SearchButton();
			
	}
	
	@Test
	public void verifyReleaseDate() throws IOException, InterruptedException
	{
		TestID=101;
			Thread.sleep(2000);
			
			String actual_ReleaseDate = searchResult.get_releaseDate();	
			
			String expected_ReleaseDate= UtilityClass.actiTimeData("ReleaseDate");
			
			
			Assert.assertEquals(actual_ReleaseDate,expected_ReleaseDate);
	}
	
	
	@Test(priority=1)
	public void verifyCountry() throws InterruptedException, IOException 
	{
		TestID=102;
		   Thread.sleep(2000);
		
		String actual_CountryName= searchResult.get_country();
		
		
		String expected_CountryName= UtilityClass.actiTimeData("Country");
		
		
		Assert.assertEquals(actual_CountryName,expected_CountryName);
		
		
	}
	
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityClass.captureScreenshot(driver,TestID);
		}
		
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//driver.close();
	}
}
