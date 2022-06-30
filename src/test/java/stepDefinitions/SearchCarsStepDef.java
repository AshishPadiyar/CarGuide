package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.DriverUtils;
import utilities.ExcelUtil;


public class SearchCarsStepDef {

	// Creating the object of page actions
	
	String tc;
	HashMap<String,String> datamap;
	 public SearchCarsStepDef() {
		tc=Hooks.TestName;
		datamap=ExcelUtil.getTestData(tc, "findCarTest");
	}

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	SearchCarsPageActions searchCarsPageActions=new SearchCarsPageActions();

	
	
//############ Step definitions	#########################

	@Given("user is on home page of {} with title {}")
	public void checkTitleOfHomePage(String strWebsiteURL,String expected) {

		String actual = carsGuideHomePageActions.SignIntitle();
		Assert.assertEquals(actual, expected);
	}


	@When("user hover to the menu")
	public void i_move_to_the_menu(List<String> data) {

		String topMenu=data.get(1);
		System.out.println("Top menu Item:"+topMenu);
		carsGuideHomePageActions.gotoTopMenu();
		
	}

	@And("click on Search Cars link")
	public void click_on_link() {
		
		carsGuideHomePageActions.clickOnSearchCars();
	}

	@And("select car brand as {}")
	public void select_car_brand_as(String strCarBrand) {
		
		searchCarsPageActions.selectCarBrand(strCarBrand);
		
	}

	@And("select model as {}")
	public void select_model_as(String strModel) {
		
		
		searchCarsPageActions.selectCarModel(strModel);
	}

	@And("select location as {}")
	public void select_location_as(String strLoc) {
		
		searchCarsPageActions.selectLocation(strLoc);
	}

	@And("select price max as {}")
	public void select_price_max_as(String strPrice) {
		
		searchCarsPageActions.selectPrice(strPrice);

	}

	@And("click on Find_My_Next_Car button")
	public void click_on_Find_My_Next_Car_button() {
		
		searchCarsPageActions.clickonFind_My_Next_Car();

	}

	@Then("user should see a list of searched cars")
	public void i_should_see_a_list_of_searched_cars() {
		
		System.out.println("Car list found");
	}

	@And("the page title should be {}")
	public void the_page_title_should_be(String expected) {
		
		String actual=DriverUtils.driver.getTitle();
		Assert.assertTrue(actual.contains(expected),"following Car title not found on the page " +expected);
	}
}
