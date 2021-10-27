package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects
{
	WebDriver driver;
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginName")
	private WebElement username;
	
	public WebElement usernameObject()
	{
		return username;
	}
	
	@FindBy(id="loginPwd")
	private WebElement password;
	
	public WebElement passwordObject() {
		return password;
	}
	
	@FindBy(id="SignIn")
	private WebElement loginbutton;
	
	public WebElement loginbuttonObject() {
		return loginbutton;
	}
}