package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver=null;
	
	public WebDriver getdriver() throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(file);
		String GlobalBrowser = prop.getProperty("BROWSER");
		String Browser_maven = System.getProperty("BROWSER");
		String Browser = Browser_maven!=null? Browser_maven : GlobalBrowser;
		
		
		if(driver == null) 
		{
			if(Browser.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
			 }
			if(Browser.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			 }
			driver.get(prop.getProperty("URL"));
		}
		return driver;
	}

}

