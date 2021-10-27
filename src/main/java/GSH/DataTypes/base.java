package GSH.DataTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base
{
	WebDriver driver;
	Properties prop;
	FileInputStream reader;
	String path="";
	public static Logger log = LogManager.getLogger(base.class);
	
	public WebDriver starter() throws IOException
	{
		path = System.getProperty("user.dir");
		
		reader = new FileInputStream(path+"/src/main/resources/ExcelToVarChar.properties");
		prop = new Properties();
		prop.load(reader);
		
		if(prop.get("browser").equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/chromedriver");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
}