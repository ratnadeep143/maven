package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

@FindBy (xpath="//input[@class='vector-search-box-input']") private WebElement search;

@FindBy (xpath="//input[@id='searchButton']") private WebElement searchButton;

	
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
		public void clickOnTime_search(String movie)
		{
			search.sendKeys(movie);
			
		}
		
		public void clickOn_SearchButton()
		{
			searchButton.click();
		}
		
		
}
