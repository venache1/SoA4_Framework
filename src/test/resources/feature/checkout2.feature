Feature: Complete order

  Background:
    When User is logged in
    And User has items in the cart

  Scenario: Complete order with default address
    Given User is on shopping page
    When checkout button is clicked
    Then Summary page is displayed
    And Products are displayed
    When Proceed to Checkout button is clicked
    Then Addresses page is displayed
    And Default Address is displayed
    When Proceed to Checkout button is clicked
    Then Shipping page is displayed
    When Terms of Service checkbox is clicked
    And Proceed to Checkout button is clicked
    Then Payment page is displayed
    When Payment method Pay by wire is clicked
    Then Order Summary page is displayed
    When I Confirm My Order button is clicked
    Then Order Confirmation page is displayed
    And Amount is displayed
    When Back To Orders button is clicked
    Then Order History page is displayed
    When Order reference is clicked
    Then FOLLOW YOUR ORDER section is displayed
    And Delivery Address is default address


  Scenario Outline: Complete order with new address
    Given User is on home page
    When checkout button is clicked
    Then Summary page is displayed
    And Products are displayed
    When Proceed to Checkout button is clicked
    Then Addresses page is displayed
    And Default Address is displayed
    When Add New Address button is clicked
    Then Your Address page is displayed
    When <First name> is entered in First name text box
    And <Last name> is completed Last name text box
    And <Address> is completed Address text box
    And <City> is completed City text box
    And <State> is selected State dropdown
    And <Phone> is completed Phone text box
    And <Address title> is completed Address title text box
    And Proceed to Checkout button is clicked
    Then Shipping page is displayed
    When Terms of Service checkbox is clicked
    And Proceed to Checkout button is clicked
    Then Payment page is displayed
    When Payment method Pay by wire is clicked
    Then Order Summary page is displayed
    When I Confirm My Order button is clicked
    Then Order Confirmation page is displayed
    And Amount is displayed
    When Back To Orders button is clicked
    Then Order History page is displayed
    When Order reference is clicked
    Then FOLLOW YOUR ORDER section is displayed
    And Delivery Address is <new Address>

    Examples:
      | First name | Last name | Address     | City          | State    | Zip   | Country       | Phone    | Address title   |
      | Tyrion     | Lanister  | Wine st. 22 | Kings Landing | New York | 12345 | United States | 01234567 | My Work Address |

