@Irina
Feature:   Write Review

  Scenario: WriteReview - Positive
    Given user is logged in
    And user navigates to "Home" page
    And user clicks on "item1"
    And user clicks on "Write a review"
    And user clicks on "Quality 3 stars"
    And user enters "Cool item" in Title field
    And user enters "Will other colors be available for this item?" in Comment field
    When user clicks on "Send"
    Then "New comment" pop-up is displayed