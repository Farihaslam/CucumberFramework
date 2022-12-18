package PageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.TestFeaturesSetup;


public class LandingPage {
	
	WebDriver driver;
	TestFeaturesSetup TestFeaturesSetup;
	
	//CONSTRUCTOR
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	//LOCATORS
	By selected_country_name = By.id("country-name");
	By current_country_btn = By.id("country-btn");
	By select_bahrain = By.id("bh");
	By select_kuwait = By.id("kw");
	By lite_plan_id = By.id("name-lite");
	By classic_plan_id = By.id("name-classic");
	By premium_plan_id = By.id("name-premium");
	By lite_price = By.xpath("//div[@id='currency-lite']//b");
	By classic_price = By.xpath("//div[@id='currency-classic']//b");
	By premium_price = By.xpath("//div[@id='currency-premium']//b");
	By ksa_currency = By.xpath("//*[@class='plan-names']/div[1]/div");
	By bh_currency = By.xpath("//*[@id='main']/div/div[1]/div[3]//i[1]");
	By kw_currency = By.xpath("//div[@id='currency-lite']//i[1]");
	
	
	//METHODS
	public String getTextFromLocator(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void SelectElementFromGivenOptions(By btn, By option) {
		driver.findElement(btn).click();
		driver.findElement(option).click();
	}
	
	public void SelectArea(String country)
	{
		if(country.equalsIgnoreCase("KSA"))
		{
			Package_Types();
		}
		else if(country.equalsIgnoreCase("Bahrain"))
		{
			SelectElementFromGivenOptions(current_country_btn, select_bahrain);
			Package_Types();
		}
		else if(country.equalsIgnoreCase("Kuwait"))
		{
			SelectElementFromGivenOptions(current_country_btn, select_kuwait);
			Package_Types();
		}
	}
	
	public void Package_Types()
	{
		Assert.assertTrue(getTextFromLocator(lite_plan_id).equalsIgnoreCase("Lite"));
		Assert.assertTrue(getTextFromLocator(classic_plan_id).equalsIgnoreCase("Classic"));
		Assert.assertTrue(getTextFromLocator(premium_plan_id).equalsIgnoreCase("Premium"));		
	}
	
	public void GetAndCompareText(String int1, String int2, String int3)
	{
		Assert.assertEquals(int1, getTextFromLocator(lite_price));
		Assert.assertEquals(int2, getTextFromLocator(classic_price));
		Assert.assertEquals(int3, getTextFromLocator(premium_price));
		
	}
	public void PriceAndCurrencyDetails(String liteprices, String classicprice, String premiumprice, String currency, String country) throws InterruptedException
	{
		switch(country) {
		case "KSA":
			GetAndCompareText(liteprices, classicprice, premiumprice);
			try {
			String str = getTextFromLocator(ksa_currency);
			String strNew= str.substring(str.length()-9, str.length());
			Assert.assertEquals(currency, strNew);
			} 
			catch (Exception e) {
				System.out.println("String Is Empty");
			}
			break;
		case "Bahrain":
			GetAndCompareText(liteprices, classicprice, premiumprice);
			Assert.assertEquals(currency, getTextFromLocator(bh_currency));
			break;
		case "Kuwait":
			GetAndCompareText(liteprices, classicprice, premiumprice);
			Assert.assertEquals(currency, getTextFromLocator(kw_currency));
			break;
		default:
			System.out.println("This is default statement");
		}
		
	}	
}
