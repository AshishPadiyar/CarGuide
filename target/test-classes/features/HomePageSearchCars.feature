
Feature: Test to check  car search funtionality in homepage

  # here you will write your user story
	@HomePage
  Scenario: Validate search cars feature at home page
    Given I am on the home page "https://www.carsguide.com.au/"
    When User at home page with title "Sign up / Sign in"
    And select car brand on homepage "BMW"
    And select model on homepage "1 Series"
    And click on show me cars
    Then i should see a list of searched cars using hompage search
    And the page title should is "Bmw 1 Series for Sale | carsguide"
