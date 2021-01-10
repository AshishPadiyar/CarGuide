package stepDefinations;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ConfigUtils;
import utilities.DriverUtils;
import utilities.ExcelUtil;


public class SearchCarsOnHomePage {

	// Creating the object of page actions
	
	String tc;
	HashMap<String,String> datamap;
	 public SearchCarsOnHomePage() {
		tc=Hooks.TestName;
		datamap=ExcelUtil.getTestData(tc, "findCarTest");
	}

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	SearchCarsPageActions searchCarsPageActions=new SearchCarsPageActions();

	
	
//############ Step definations	#########################

	@Given("I am on the home page {string}")
	public void i_am_on_the_home_page(String strwebsiteURL) {
		
		 System.out.println("test data"+datamap);
	}

	@When("User at home page with title {string}")
	public void User_at_home_page_with_title(String expected) {

		String actual=carsGuideHomePageActions.SignIntitle();
		Assert.assertEquals(actual, expected);
		
	}

	@And("select car brand on homepage {string}")
	public void select_car_brand_on_homepage(String strCarBrand) {
		
		searchCarsPageActions.selectCarBrand(strCarBrand);
		ConfigUtils.log.info("User select the car brand");
		
	}

	@And("select model on homepage {string}")
	public void select_model_on_homepage(String strModel) {
		
		searchCarsPageActions.selectCarModel(strModel);
		ConfigUtils.log.info("User select the car Model");
	}

	@And("click on show me cars")
	public void click_on_show_me_cars() {
		
		carsGuideHomePageActions.clickOnShowMeCars();

	}

	@Then("i should see a list of searched cars using hompage search")
	public void i_should_see_a_list_of_searched_cars_using_hompage_search() {
		
		System.out.println("Car list found");
	}

	@And("the page title should is {string}")
	public void the_page_title_should_is(String expected) {
		
		String actual=DriverUtils.driver.getTitle();
		
		Assert.assertEquals(actual, expected);
	}
}
