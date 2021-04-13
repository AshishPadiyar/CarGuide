package stepDefinations;

import java.util.ArrayList;
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


public class PopularArticle {

	// Creating the object of page actions
	
	String tc;
	HashMap<String,String> datamap;
	 public PopularArticle() {
		tc=Hooks.TestName;
		datamap=ExcelUtil.getTestData(tc, "findCarTest");
	}

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	SearchCarsPageActions searchCarsPageActions=new SearchCarsPageActions();

	
	
//############ Step definations	#########################

//	@Given("User on the homepage {string}")
//	public void user_on_the_homepage(String string) {
//		System.out.println("test data"+datamap);
//	}

//	@When("User validate homepage with title {string}")
//	public void user_validate_homepage_with_title(String expected) {
//		String actual=carsGuideHomePageActions.SignIntitle();
//		Assert.assertEquals(actual, expected);
//	}

	@When("user scrolls the window till popular article")
	public void user_scrolls_the_window_till_popular_article() {
	    carsGuideHomePageActions.ScrollToPopularArticle();
	}

	@Then("user selects the article one by one")
	public void user_selects_the_article_one_by_one() {
	    carsGuideHomePageActions.clickArticleLink();
	}
}
