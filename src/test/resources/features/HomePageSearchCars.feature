Feature: Test to check car search functionality in homepage

  Background: Navigate to carguide site
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in


  Scenario: Validate search cars feature at home page
    And select car brand on homepage BMW
    And select model on homepage 1 Series
    And click on show me cars
    Then user should see a list of searched cars using hompage search
    And the page title should is Bmw 1 Series for Sale | carsguide


  Scenario Outline: Scenario: To check Most popular Reviews
    And  user scrolls the window till popular review
    Then user selects review of "<car>"
    And  user verify the page title for "<car>"
    Examples:
      | car                 |
      | Ford Ranger         |
      | Toyota Land Cruiser |


  Scenario Outline:To check Search TextBox on homepage
    Then user try to search for "<car>"
    And  user verify the page title for "<car>"
    Examples:
      | car    |
      | bmw i3 |
      | bmw x4 |


  Scenario: To check Footer Links on homepage
    And  user scrolls to the button of the page
    Then  User fetch the name of all the links
