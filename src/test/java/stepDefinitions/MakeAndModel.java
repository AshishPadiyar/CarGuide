package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageactions.CarsGuideHomePageActions;
import pageactions.SearchCarsPageActions;
import utilities.ExcelUtil;

import java.util.HashMap;


public class MakeAndModel {

    // Creating the object of page actions

    String tc;
    HashMap<String, String> datamap;
    CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
    SearchCarsPageActions searchCarsPageActions = new SearchCarsPageActions();
    public MakeAndModel() {
        tc = Hooks.TestName;
        datamap = ExcelUtil.getTestData(tc, "findCarTest");
    }


//############ Step definitions	#########################

    @And("user clicks on Make")
    public void userClicksOnMake() {
        carsGuideHomePageActions.ClickOnMake();

    }

    @Then("User selects car and display all the model")
    public void userSelectsCarAndDisplayAllTheModel() {
        carsGuideHomePageActions.ClickOnModel();
    }

    @Then("User selects car and display all the model in a map")
    public void userSelectsCarAndDisplayAllTheModelInAMap() {
        carsGuideHomePageActions.retrieveMakeAndModelFromMap();
    }
}
