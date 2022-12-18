package PageObjects;

import org.openqa.selenium.WebDriver;
//import Utils.TestFeaturesSetup;

public class PageObjectManager {

public LandingPage LandingPage;
public Utils.TestFeaturesSetup TestFeaturesSetup;
public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
		LandingPage = new LandingPage(driver);
		return LandingPage;
	}
}
