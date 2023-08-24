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

//	@Given("User on the homepage {string}")
//	public void user_on_the_homepage(String string) {
//		System.out.println("test data"+datamap);
//	}

//	@When("User validate homepage with title {string}")
//	public void user_validate_homepage_with_title(String expected) {
//		String actual=carsGuideHomePageActions.SignIntitle();
//		Assert.assertEquals(actual, expected);
//	}

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
