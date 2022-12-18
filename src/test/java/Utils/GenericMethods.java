package Utils;

import org.openqa.selenium.WebDriver;

public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();		
	}

}
