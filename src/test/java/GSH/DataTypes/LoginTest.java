package GSH.DataTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.FolderObjects;
import pageObjects.HomeLinkObjects;
import pageObjects.LoginPageObjects;
import pageObjects.MenuOptionsObject;
import pageObjects.QueryInterfaceObjects;

public class LoginTest extends base
{
	@BeforeTest
	public void setup() throws IOException
	{
		driver = starter();
		log.info("Driver initated successfully and url picked up");
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() throws IOException
	{
		LoginPageObjects login = new LoginPageObjects(driver);
		
		log.info("Url loaded and logining into system using valid credentails");
		login.usernameObject().sendKeys(prop.getProperty("username"));
		login.passwordObject().sendKeys(prop.getProperty("password"));
		login.loginbuttonObject().click();
	}
	
	@Test(dependsOnMethods = {"loginTest"}, dataProvider="getReportName")
	public void clickCreateNewReport(String reportName) throws InterruptedException
	{
		log.info("Login Sucessful");
		MenuOptionsObject menu = new MenuOptionsObject(driver);
		
		log.info("Click on create new report");
		menu.createNewReportObject().click();
		Thread.sleep(10000);
		
		FolderObjects folder = new FolderObjects(driver);
		log.info("Click on foldername");
		folder.folderObject().click();
		
		List<WebElement>subfolders = folder.reportObject();
		for(WebElement sub : subfolders)
		{
			if(sub.getText().contains("Reports"))
			{
				sub.click();
				log.info("Report module selected");
				break;
			}
		}
		
		folder.searchReportObject().sendKeys(reportName);
		log.info("search for report");
		List<WebElement>searchedReport = folder.selectsearchedReportObject();
		for(WebElement searched : searchedReport)
		{
			if(searched.getText().equals(reportName))
			{
				log.info("select searched report");
				searched.click();
				
				log.info("Click Edit report");
				folder.editreportObject().click();
				Thread.sleep(5000);
				
				QueryInterfaceObjects queryUI = new QueryInterfaceObjects(driver);
				
				log.info("Click next on Query Interface");
				queryUI.nextOnQueryInterfaceObject().click();
				
				log.info("Click on Save Report definition");
				queryUI.savequeryObject().click();
				
				log.info("Final click to save definition");
				queryUI.saveDefinitionObject().click();
				
				HomeLinkObjects home = new HomeLinkObjects(driver);
				Thread.sleep(5000);
				
				log.info("Click home button");
				home.homeButtonObject().click();
				
				log.info("choose home option");
				home.goToHomePageObject().click();
				Thread.sleep(5000);
				
				break;
			}
		}
	}
	
	@DataProvider(name="getReportName")
	public Object[][] getData() throws IOException
	{
		Object[][] obj = new Object[3][1];
		ExcelReader reader = new ExcelReader();
		FileInputStream stream = new FileInputStream(path+"/src/main/resources/ExcelForVarcharChange.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		
		int rows = reader.getNumberOfRows(sheet);
		
		for(int i=1;i<=rows-1;i++)
		{
			obj[i-1][0] =  reader.getExcelData(i,2, sheet);
		}
		return obj;
	}
}