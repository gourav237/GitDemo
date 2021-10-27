package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuOptionsObject 
{
	WebDriver driver;
	public MenuOptionsObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="new_report")
	private WebElement createNewReport;
	
	public WebElement createNewReportObject()
	{
		return createNewReport;
	}
}