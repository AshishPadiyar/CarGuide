
Feature: Test to check the number of tabs in homepage

  # here you will write your user story
	@HomePageTabs
  Scenario: Validate number of tabs on home page
    Given User on the homepage "https://www.carsguide.com.au/"
    When User validate homepage with title "Sign up / Sign in"
    Then Verify tabs on homepage
