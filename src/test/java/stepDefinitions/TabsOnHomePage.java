package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ConfigUtils;
import utilities.ExcelUtil;


public class TabsOnHomePage {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();
    public TabsOnHomePage() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

    @Then("Verify tabs on homepage")
    public void verify_tabs_on_homepage() {
        ArrayList<String> tabs = carsGuideHomePageActions.HomePageTabs();
        for (int i = 0; i < tabs.size(); i++) {
            System.out.println(i + 1 + " tab name is " + tabs.get(i));
            ConfigUtils.log.info(tabs);
        }
    }
}
