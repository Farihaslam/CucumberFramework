package StepDefinition;

import org.junit.Assert;

import Utils.TestFeaturesSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stc_tv_plans_steps {

	PageObjects.LandingPage LandingPage;
	Utils.GenericMethods GenericMethods;
	TestFeaturesSetup TestFeaturesSetup;

		public Stc_tv_plans_steps(TestFeaturesSetup TestFeaturesSetup){
			this.TestFeaturesSetup=TestFeaturesSetup;
			this.LandingPage = TestFeaturesSetup.PageObjectManager.getLandingPage();
			this.GenericMethods = TestFeaturesSetup.GenericMethods;
		}

	    @Given("^User Is on Landing Page$")
	    public void user_is_on_landing_page() throws Throwable {
	    	Assert.assertTrue(GenericMethods.getPageTitle().contains("stc tv - Watch Online movies, series & live TV | Enjoy Free Trial"));
	    }
	    
	    @When("^(.+) Is selected In Dropdown$")
	    public void is_selected_in_dropdown(String country) throws Throwable {
	    	LandingPage.SelectArea(country);    	
	    }
	    
	    @Then("^Validate Lite Price (.+), Classic Prices (.+) and Premium (.+) with Currency (.+) for all Countries (.+)$")
	    public void validate_prices_with_currency_for_all_countries(String liteprices, String classicprice, String premiumprice, String currency, String country) throws Throwable {
	    	System.out.println("check the browser");
	    	LandingPage.PriceAndCurrencyDetails(liteprices, classicprice, premiumprice, currency, country);
	    }
}
