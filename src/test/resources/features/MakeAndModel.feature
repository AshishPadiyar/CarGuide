Feature: Test to check the number of Cars under certain Model in homepage


  Background: Navigate to carguide site
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in


  Scenario: To check numbers of Cars under particular model on the homepage
    And  user clicks on Make
    Then User selects car and display all the model


  Scenario: To check numbers of Cars under particular model on the homepage
    And  user clicks on Make
    Then User selects car and display all the model in a map
