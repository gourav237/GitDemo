package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FolderObjects
{
	WebDriver driver;
	public FolderObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='folder']")
	private WebElement folder;
	
	public WebElement folderObject()
	{
		return folder;
	}
	
	@FindBys(@FindBy(xpath="//ul[@id='userfolders']/li/ul/li"))
	private List<WebElement> report;
	
	public List<WebElement> reportObject()
	{
		return report;
	}
	
	@FindBy(id="search_file")
	private WebElement searchReport;
	
	public WebElement searchReportObject()
	{
		return searchReport;
	}
	
	@FindBys(@FindBy(xpath="//table[@id='filesTable']/tfoot/tr/td/a"))
	private List<WebElement> selectsearchedReport;
	
	public List<WebElement> selectsearchedReportObject()
	{
		return selectsearchedReport;
	}
	
	@FindBy(id="editreport")
	private WebElement editreport;
	
	public WebElement editreportObject()
	{
		return editreport;
	}
}