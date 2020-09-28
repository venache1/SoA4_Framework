@Claudia

Feature: Add, remove and modify items from shopping cart

  Background:
    Given user is on Home page
    And user navigates to Women items page

  Scenario: Add items to cart
    When user adds items with following price
      | Item price |
      | $16.51     |
      | $27.00     |
    And click on [Add to cart] button
    Then a pop up window is displayed with message "Product successfully added to your shopping cart"
    And item details are displayed

  Scenario: Remove items from cart
    And user adds items with following price
      | Item price |
      | $16.51     |
      | $27.00     |
    And user navigates to shopping cart page
    And 'Shopping cart summary' page is displayed
    When user clicks on [delete] button for item with price '$16.51'
    Then the item is deleted from the list
    And the following fields are updated
      | Total products | $27.00 |
      | Total          | $29.00 |
      | TOTAL          | $29.00 |

  Scenario: Modify number of items from shopping cart
    And user adds the following items to shopping cart
      | Items                       | Quantity | Item Price |
      | Blouse                      | 1        | $27.00     |
      | Faded Short Sleeve T-shirts | 2        | $16.51     |
    And user navigates to shopping cart page
    And 'Shopping cart summary' page is displayed
    When user press on '+' button for item 'Blouse'
    Then the quantity of item is changed to 2
    And the following fields are updated
      | Total products | $87.02 |
      | Total          | $89.02 |
      | TOTAL          | $89.02 |
    When user press on '-' button for item 'Faded Short Sleeve T-shirts'
    Then the quantity of item is changed to 1
    And the following fields are updated
      | Total products | $70.51 |
      | Total          | $72.51 |
      | TOTAL          | $72.51 |