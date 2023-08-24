
Feature: Acceptence testing to validate search cars page is working
  Inorder to validate that search cars page is working fine
  we will do the acceptence testing

  # here you will write your user story
  @searchcar
  Scenario: Validate search cars page
    Given I am on the home page of "https://www.carsguide.com.au/"
    When i move to the menu
      | menu     |
      | buy+sell |
    And click on "Search Cars" link
    And select car brand as "BMW"
    And select model as "1 Series"
    And select location as "NSW - Central Coast"
    And select price max as "$40,000"
    And Click on Find_My_Next_Car button
    Then i should see a list of searched cars
    And the page title should be "BMW 1 Series"
