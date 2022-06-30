Feature: Acceptance testing to validate search cars page is working
  In order to validate that search cars page is working fine
  we will do the acceptance testing


  Scenario: Validate search cars page
    Given user is on home page of https://www.carsguide.com.au/ with title Sign up / Sign in
    When user hover to the menu
      | menu     |
      | buy+sell |
    And click on Search Cars link
    And select car brand as BMW
    And select model as 1 Series
    And select location as NSW - Central Coast
    And select price max as $40,000
    And click on Find_My_Next_Car button
    Then user should see a list of searched cars
    And the page title should be Bmw 1 Series
