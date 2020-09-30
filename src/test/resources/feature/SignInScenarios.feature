@Anatolie
Feature: Sign in and Forgot password

  Background:
    Given User is on "Authentication" page

  Scenario: Login validation with correct data
    When User introduce "test01@test.com" into "Email address" field
    And User introduce "1@aBc" into "Password" field
    And User clicks on "Sing in" button
    Then User is redirected to "My account" page


  Scenario Outline: Verify error handling on Authentication page (Negative scenario)
    When User introduce '<email>' into "Email address"
    And User introduce '<password>' into "Password"
    And User clicks on "Sing in" button
    Then The error message is displayed "There is 1 error"

    Examples:
      | email         | password |
      | test01@       |          |
      |               |          |
      | @             | 1        |
      | test@test.com |          |


  Scenario: Verify Retrieve Password confirmation message
    And User clicks "forgot your password" link
    And User is redirected to "Forgot your password" page
    When User introduce "test01@test.com" into "Email address" field
    And User clicks on "Retrieve Password" button
    Then the confirmation message is displayed "A confirmation email has been sent to your address: test01@test.com" on "Forgot your password" page