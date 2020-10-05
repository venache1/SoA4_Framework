@Irina @run
Feature: Write Review

  Scenario: WriteReview - Positive
    Given user is logged in app
    And user navigates to Home page
    And user clicks on item1
    And user clicks on Write a review
    And user clicks on Quality 5 stars
    And user enters Wonderful dress text in Title field
    And user enters Waiting for other colors text in Comment field
    When user clicks on Send button
    Then New comment pop-up is displayed