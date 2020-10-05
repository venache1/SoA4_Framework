@Claudia @run
Feature: Add, remove and modify items from shopping cart

  Background:
    Given user is on Home page
    And user navigates to 'WOMEN' items page

  Scenario: Add items to cart
    When user clicks on Add to card button for item
      | $16.51 |
    Then a pop up window is displayed with message "Product successfully added to your shopping cart"
    And item details are displayed on pop-up
    When user clicks on Proceed to checkout button
    Then Shopping-cart summary page is displayed
    And added item is in shopping cart
      | $16.51 |

  Scenario: Remove items from cart
    And user adds items with following price
      | $16.51 |
      | $27.00 |
    And user navigates to shopping cart page
    And Shopping cart summary page is displayed
    And the total values are
      | Field                   | Value  |
      | Total products          | $43.51 |
      | Total shipping          | $2.00  |
      | Total Price Without Tax | $45.51 |
      | Tax                     | $0.00  |
      | TOTAL                   | $45.51 |
    When user clicks on [delete] button for item with price '$16.51'
    Then the item with price '$16.51' is deleted from the list
    And the total values are
      | Field                   | Value  |
      | Total products          | $27.00 |
      | Total shipping          | $2.00  |
      | Total Price Without Tax | $29.00 |
      | Tax                     | $0.00  |
      | TOTAL                   | $29.00 |

  Scenario: Modify number of items from shopping cart
    And user adds items with following price
      | $16.51 |
      | $27.00 |
    And user navigates to shopping cart page
    And Shopping cart summary page is displayed
    And the total values are
      | Field                   | Value  |
      | Total products          | $43.51 |
      | Total shipping          | $2.00  |
      | Total Price Without Tax | $45.51 |
      | Tax                     | $0.00  |
      | TOTAL                   | $45.51 |
    When user press on '+' button for item with price '$16.51'
    Then the quantity of item with price '$16.51' is changed to '2'
    And the total values are
      | Field                   | Value  |
      | Total products          | $60.02 |
      | Total shipping          | $2.00  |
      | Total Price Without Tax | $62.02 |
      | Tax                     | $0.00  |
      | TOTAL                   | $62.02 |
    When user press on '-' button for item with price '$16.51'
    Then the quantity of item with price '$16.51' is changed to '1'
    And the total values are
      | Field                   | Value  |
      | Total products          | $43.51 |
      | Total shipping          | $2.00  |
      | Total Price Without Tax | $45.51 |
      | Tax                     | $0.00  |
      | TOTAL                   | $45.51 |