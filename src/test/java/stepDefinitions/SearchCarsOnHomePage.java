package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ConfigUtils;
import utilities.DriverUtils;
import utilities.ExcelUtil;

import java.util.HashMap;


public class SearchCarsOnHomePage {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();

    public SearchCarsOnHomePage() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

    @And("select car brand on homepage {}")
    public void select_car_brand_on_homepage(String strCarBrand) {

        searchCarsPageActions.selectCarBrand(strCarBrand);
        ConfigUtils.log.info("User select the car brand");

    }

    @And("select model on homepage {}")
    public void select_model_on_homepage(String strModel) {

        searchCarsPageActions.selectCarModel(strModel);
        ConfigUtils.log.info("User select the car Model");
    }

    @And("click on show me cars")
    public void click_on_show_me_cars() {

        carsGuideHomePageActions.clickOnShowMeCars();

    }

    @Then("user should see a list of searched cars using hompage search")
    public void i_should_see_a_list_of_searched_cars_using_hompage_search() {

        System.out.println("Car list found");
    }

    @And("the page title should is {}")
    public void the_page_title_should_is(String expected) {

        String actual = DriverUtils.driver.getTitle();

        Assert.assertEquals(actual, expected);
    }

    @When("user scrolls the window till popular review")
    public void user_scrolls_the_window_till_popular_review() {
        carsGuideHomePageActions.Scroll();
    }


    @Then("user selects review of {string}")
    public void user_selects_review_of_car(String car) {
        carsGuideHomePageActions.GetCarName(car);

    }

    @And("user verify the page title for {string}")
    public void user_verify_the_page_title_for_car(String car) {

        String varCarTitle = carsGuideHomePageActions.GetCarTitle();
        System.out.println("Car title for " + car + " is " + varCarTitle);
    }

    @Then("user try to search for {string}")
    public void user_try_to_search_for_car(String car) {
        carsGuideHomePageActions.CarSearchTextBox(car);

    }

    @And("user scrolls to the button of the page")
    public void user_scrolls_to_the_button_of_the_page() {
        DriverUtils.ScrollToBottom();
        System.out.println("User at the button of the page");
    }

    @Then("User fetch the name of all the links")
    public void user_fetch_the_name_of_all_the_links() {
        carsGuideHomePageActions.HomePageFooters();

    }


}
