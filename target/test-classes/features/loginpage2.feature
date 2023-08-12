
Feature: HubSpot login feature

@Smoke
  Scenario: Logging into account
    Given user is on the website
    And user clicks on the login button
    When user enters valid "narinders163@gmail.com" and "Harman&123"
    And clicks log in
    Then user should be able to login to the account
    And verify the username is correct
