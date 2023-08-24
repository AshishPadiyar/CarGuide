package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.DriverUtils;
import utilities.ExcelUtil;

import java.util.HashMap;
import java.util.List;


public class SearchCarsStepDef {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();

    public SearchCarsStepDef() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

    @Given("I am on the home page of {string}")
    public void i_am_on_the_home_page_of(String strwebsiteURL) {

        System.out.println("test data" + datamap);
    }

    @When("i move to the menu")
    public void i_move_to_the_menu(List<String> data) {

        String topMenu = data.get(1);
        System.out.println("Top menu Item:" + topMenu);
        carsGuideHomePageActions.gotoTopMenu();

    }

    @And("click on {string} link")
    public void click_on_link(String strsearchcarslink) {

        carsGuideHomePageActions.clickonSearchCars();
    }

    @And("select car brand as {string}")
    public void select_car_brand_as(String strCarBrand) {

        searchCarsPageActions.selectCarBrand(strCarBrand);

    }

    @And("select model as {string}")
    public void select_model_as(String strModel) {


        searchCarsPageActions.selectCarModel(strModel);
    }

    @And("select location as {string}")
    public void select_location_as(String strLoc) {

        searchCarsPageActions.selectLocation(strLoc);
    }

    @And("select price max as {string}")
    public void select_price_max_as(String strPrice) {

        searchCarsPageActions.selectPrice(strPrice);

    }

    @And("Click on Find_My_Next_Car button")
    public void click_on_Find_My_Next_Car_button() {

        searchCarsPageActions.clickonFind_My_Next_Car();

    }

    @Then("i should see a list of searched cars")
    public void i_should_see_a_list_of_searched_cars() {

        System.out.println("Car list found");
    }

    @And("the page title should be {string}")
    public void the_page_title_should_be(String expected) {

        String actual = DriverUtils.driver.getTitle();
        Assert.assertTrue(actual.contains(expected));
    }
}
