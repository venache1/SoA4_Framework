@Artiom
Feature: Wish List

  Background:
    Given user is on landing page

  Scenario: Create Wish List
    Given user is logged in
    And user is on MY WISHLISTS page
    And user type on name field My favourite
    When user clicks on Save button
    Then Wishlist is created

  Scenario: Add to wishlist/see the item
    And user is on main page
    And user clicks on Blouse item
    And user is redirected on item page
    When user clicks on Add to wish list button
    And user navigates to My Wishlists page
    Then item is displayed on wishlist
    And item details are displayed

  Scenario: Remove item from wish list
    And user have items on wish lists
    And user is on wishlist page
    When user clicks on delete button for item
    Then item is removed from wishlist



