@regression
Feature: User Open Browser and Login

Background: user open browser and go to login page
  Given user open Browser
  And user navigate to login page

# Test Scenario: 1
Scenario: user login with valid username and password

  When user enter "tomsmith" and "SuperSecretPassword!"
  And user click on login BTN
  Then user could login successfully
  And user go to home page


# Test Scenario: 2
Scenario: user login with invalid username and password

  When user enter "wrong" and "wrong!"
  And user click on login BTN
  Then user could not login
