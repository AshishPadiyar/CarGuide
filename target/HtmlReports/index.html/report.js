$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/HomePageSearchCars.feature");
formatter.feature({
  "name": "Test to check  car search functionality in homepage",
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
  "name": "To check Footer Links on hompage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePage"
    }
  ]
});
formatter.step({
  "name": "user scrolls to the button of the page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.user_scrolls_to_the_button_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User fetch the name of all the links",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.user_fetch_the_name_of_all_the_links()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});