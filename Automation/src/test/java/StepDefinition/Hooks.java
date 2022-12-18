package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
Utils.TestFeaturesSetup TestFeaturesSetup;
	
	public Hooks(Utils.TestFeaturesSetup TestFeaturesSetup)
	{
		this.TestFeaturesSetup = TestFeaturesSetup;
	}

	@Before
	public void initializeTest() throws IOException {
		TestFeaturesSetup.BaseClass.getdriver().manage().window().maximize();
		TestFeaturesSetup.BaseClass.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		TestFeaturesSetup.BaseClass.getdriver().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario Scenario) throws IOException
	{
		WebDriver driver = TestFeaturesSetup.BaseClass.getdriver();
		if(Scenario.isFailed()) {
			try {
				Scenario.log(Scenario.getName() + "is Failed");
				File SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				byte[] FileContent = FileUtils.readFileToByteArray(SourcePath);
				Scenario.attach(FileContent, "image/png", "image");
				}
			catch (WebDriverException e) {
				e.printStackTrace();
			}		
		}
		else {Scenario.log(Scenario.getName() + " is Pass");
		}
	}

}
