package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestFeaturesSetup {
	
	public WebDriver driver;
	public PageObjects.PageObjectManager PageObjectManager;
	public BaseClass BaseClass;
	public GenericMethods GenericMethods;
	
	public TestFeaturesSetup() throws IOException {
		BaseClass = new BaseClass();
		PageObjectManager = new PageObjects.PageObjectManager(BaseClass.getdriver());
		GenericMethods = new GenericMethods(BaseClass.getdriver());
		
	}

}
