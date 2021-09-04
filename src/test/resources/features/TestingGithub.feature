
Feature: Test git hub branching process
  We will learn how to create,merge,delete branches to master
  checking on pull request template

  # here you will write your user story
  
  Background: Navigate to carguide site
    Given I am on the home page "https://www.carsguide.com.au/"
    When User at home page with title "Sign up / Sign in"
    
    

  Scenario: To check different buying guides on the homepage
    And  user scrolls the window till Buying Guides
    Then user selects each buying guide article one by one

