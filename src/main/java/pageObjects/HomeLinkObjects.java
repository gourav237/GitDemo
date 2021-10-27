package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLinkObjects
{
	WebDriver driver;
	public HomeLinkObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='usrnameDiv']/p")
	private WebElement homeButton;
	
	public WebElement homeButtonObject()
	{
		return homeButton;
	}
	
	@FindBy(xpath="//ul[@class='signoutLink']/li/div/a")
	private WebElement goToHomePage;
	
	public WebElement goToHomePageObject()
	{
		return goToHomePage;
	}
}
