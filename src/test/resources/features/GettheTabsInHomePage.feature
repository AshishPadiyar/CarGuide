Feature: Test to check the number of tabs in homepage

  Scenario: Validate number of tabs on home page
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in
    Then Verify tabs on homepage
