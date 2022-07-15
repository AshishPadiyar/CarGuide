package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ExcelUtil;

import java.util.HashMap;


public class BuyingGuides {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();

    public BuyingGuides() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

//	@Given("User on the homepage {string}")
//	public void user_on_the_homepage(String string) {
//		System.out.println("test data"+datamap);
//	}

    @When("user scrolls the window till Buying Guides")
    public void user_scrolls_the_window_till_Buying_Guides() {

        carsGuideHomePageActions.ScrollToBuyingGuides();
    }

    @Then("user selects each buying guide article one by one")
    public void user_selects_each_buying_guide_article_one_by_one() {

        carsGuideHomePageActions.ClickEachBuyingGuide();
    }

    @And("send http request and checks for broken link")
    public void sendHttpRequestAndChecksForBrokenLink() {
        carsGuideHomePageActions.getBrokenLinks();

    }
}
