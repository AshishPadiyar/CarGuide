Feature: Test git hub branching process
  We will learn how to create,merge,delete branches to master
  checking on pull request template


  Background: Navigate to carguide site
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in


  Scenario: To check different buying guides on the homepage
    And  user scrolls the window till Buying Guides
    Then user selects each buying guide article one by one

