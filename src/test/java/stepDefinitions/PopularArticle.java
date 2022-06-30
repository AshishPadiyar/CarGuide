package stepDefinitions;

import java.util.HashMap;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ExcelUtil;


public class PopularArticle {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();
    public PopularArticle() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

    @When("user scrolls the window till popular article")
    public void user_scrolls_the_window_till_popular_article() {
        carsGuideHomePageActions.ScrollToPopularArticle();
    }

    @Then("user selects the article one by one")
    public void user_selects_the_article_one_by_one() {
        carsGuideHomePageActions.clickArticleLink();
    }
}
