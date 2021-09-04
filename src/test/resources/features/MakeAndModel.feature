
Feature: Test to check the number of Cars under certain Model in homepage

  # here you will write your user story
  
  Background: Navigate to carguide site
    Given I am on the home page "https://www.carsguide.com.au/"
    When User at home page with title "Sign up / Sign in"
    
    
	@MakeAndModel
  Scenario: To check numbers of Cars under particular model on the homepage
    And  user clicks on Make
    Then User selects car and display all the model

  @MakeAndModel
  Scenario: To check numbers of Cars under particular model on the homepage
    And  user clicks on Make
    Then User selects car and display all the model in a map
