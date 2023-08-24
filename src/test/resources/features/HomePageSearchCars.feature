
Feature: Test to check  car search functionality in homepage

  Background: Navigate to carguide site
    Given I am on the home page "https://www.carsguide.com.au/"
    When User at home page with title "Sign up / Sign in"


  Scenario: Validate search cars feature at home page
    * select car brand on homepage "BMW"
    And select model on homepage "1 Series"
    And click on show me cars
    Then i should see a list of searched cars using hompage search
    And the page title should is "BMW 1 Series for Sale | CarsGuide"


  Scenario Outline: Scenario: To check Most populer Reviews
    And  user scrolls the window till populer review
    Then user selects review of "<car>"
    And  user verify the page title for "<car>"
    Examples:
      |car|
      |Ford Ranger|
      |Isuzu D-Max|


  Scenario Outline:To check Search TextBox on hompage
    Then user try to search for "<car>"
    And  user verify the page title for "<car>"
    Examples:
      |car|
      |bmw x1|
      |bmw x3|

  @HomePage
  Scenario: To check Footer Links on hompage
    And  user scrolls to the button of the page
    Then  User fetch the name of all the links
