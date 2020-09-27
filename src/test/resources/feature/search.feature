Feature: Search functionality

  Scenario: Search for items
    Given User is on the Home Page
    And Search text box is displayed
    When Item name is entered in the Search text box
    And Search button is clicked
    Then Search Results page is displayed
    When Price: Highest first is selected in Sort by drop down
    Then Items are displayed in descending order

  Scenario: Select Item from Search options
  Given User is on the Home Page
    And Search text box is displayed
    When Item name is entered in the Search text box
    Then first option contains Item name
    When first option is selected
    Then In Stock is selected in Sort by drop down
    Then List of items is displayed
    And All Items have In Stock True

