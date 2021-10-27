package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueryInterfaceObjects
{
	WebDriver driver;
	public QueryInterfaceObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="generatewhereclause")
	private WebElement nextOnQueryInterface;
	
	public WebElement nextOnQueryInterfaceObject()
	{
		return nextOnQueryInterface;
	}
	
	@FindBy(id="savequery")
	private WebElement savequery;
	
	public WebElement savequeryObject()
	{
		return savequery;
	}
	
	@FindBy(id="continuetouserhome")
	private WebElement saveDefinition;
	
	public WebElement saveDefinitionObject()
	{
		return saveDefinition;
	}
}