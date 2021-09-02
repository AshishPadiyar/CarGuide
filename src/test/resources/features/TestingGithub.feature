
Feature: Test git hub branching process
  We will learn how to create,merge,delete branches to master

  # here you will write your user story
  
  Background: Navigate to carguide site
    Given I am on the home page "https://www.carsguide.com.au/"
    When User at home page with title "Sign up / Sign in"
    
    
	@BuyingGuide
  Scenario: To check different buying guides on the homepage
    And  user scrolls the window till Buying Guides
    Then user selects each buying guide article one by one

