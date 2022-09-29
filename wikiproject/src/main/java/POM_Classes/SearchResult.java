package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult 
{

	@FindBy (xpath="(//table[@class='infobox vevent']//div[@class='plainlist'])[4]") private WebElement releaseDate;
	@FindBy (xpath="(//table[@class='infobox vevent']//td[@class='infobox-data'])[12]") private WebElement country;

	
	
	public SearchResult(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
		public String get_releaseDate()
		{
			String date= releaseDate.getText();
			return date;
		}
		
		public String get_country()
		{
			String cName=country.getText();
			return cName;
		}
}
