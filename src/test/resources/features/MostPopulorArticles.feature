Feature: Test to check the number of tabs in homepage

  Background: Navigate to carguide site
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in


  Scenario: To check Most popular Articles on the homepage
    And  user scrolls the window till popular article
    Then user selects the article one by one

