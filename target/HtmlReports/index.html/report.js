$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/HomePageSearchCars.feature");
formatter.feature({
  "name": "Test to check  car search funtionality in homepage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate search cars feature at home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePage"
    }
  ]
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
formatter.step({
  "name": "select car brand on homepage \"BMW\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.select_car_brand_on_homepage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select model on homepage \"1 Series\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.select_model_on_homepage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on show me cars",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.click_on_show_me_cars()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i should see a list of searched cars using hompage search",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.i_should_see_a_list_of_searched_cars_using_hompage_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the page title should is \"Bmw 1 Series for Sale | carsguide\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.SearchCarsOnHomePage.the_page_title_should_is(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});