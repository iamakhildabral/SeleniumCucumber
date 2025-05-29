@smoke
Feature: Login Test Scenario
  Background:
    Given User is on Login Page
  @regression
  Scenario: Login
    When User enter valid username
    And User enter valid password
    And User click on Login button
    Then User navigate to homepage
    When User click on Menu Button
    And User click on Logout Button
    Then User sees Login Page

