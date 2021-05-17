$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/MakeAndModel.feature");
formatter.feature({
  "name": "Test to check the number of tabs in homepage",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Navigate to carguide site",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the home page \"https://www.carsguide.com.au/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.i_am_on_the_home_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User at home page with title \"Sign up / Sign in\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.User_at_home_page_with_title(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To check Most popular Articles on the homepage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MakeAndModel"
    }
  ]
});
formatter.step({
  "name": "user clicks on Make",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.MakeAndModel.userClicksOnMake()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects car and display all the model",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.MakeAndModel.userSelectsCarAndDisplayAllTheModel()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Navigate to carguide site",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the home page \"https://www.carsguide.com.au/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.i_am_on_the_home_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User at home page with title \"Sign up / Sign in\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.User_at_home_page_with_title(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To check Most popular Articles on the homepage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MakeAndModel"
    }
  ]
});
formatter.step({
  "name": "user clicks on Make",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.MakeAndModel.userClicksOnMake()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects car and display all the model in a map",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.MakeAndModel.userSelectsCarAndDisplayAllTheModelInAMap()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});