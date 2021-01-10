$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/GettheTabsInHomePage.feature");
formatter.feature({
  "name": "Test to check the number of tabs in homepage",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate number of tabs on home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePageTabs"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User on the homepage \"https://www.carsguide.com.au/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.TabsOnHomePage.user_on_the_homepage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validate homepage with title \"Sign up / Sign in\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.TabsOnHomePage.user_validate_homepage_with_title(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify tabs on homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.TabsOnHomePage.verify_tabs_on_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});