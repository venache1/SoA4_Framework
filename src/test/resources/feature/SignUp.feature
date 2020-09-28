@Irina
Feature: SignUp

  Background:
    Given user is on "CREATE AN ACCOUNT" page

  Scenario: SignUp with valid data
    When user enters data into fields:
      | fields                                        | values                   |
      | First name                                    | John                     |
      | Last name                                     | Smitherson               |
      | Email                                         | j.smithffg@maili.com     |
      | Password                                      | Ab12%                    |
      | First name                                    | John                     |
      | Last name                                     | Smitherson               |
      | Address                                       | Brunlich, 35001, Broenna |
      | City                                          | Carrley                  |
      | State                                         | Alabama                  |
      | Zip/Postal Code                               | 00000                    |
      | Country                                       | United States            |
      | Mobile phone                                  | 105454545                |
      | Assign an address alias for future reference. | Home address             |
    And user clicks on "Register"
    Then "My Account" is displayed
    And user name is displayed in Navigation bar

  Scenario: SignUp with invalid data
    When user enters data into fields:
      | fields                                        | values      |
      | First name                                    | Arr457      |
      | Last name                                     |             |
      | Email                                         | j.smithffg@ |
      | Password                                      | A1%         |
      | First name                                    | Zery5       |
      | Last name                                     | 7Alkim      |
      | Address                                       |             |
      | City                                          |             |
      | Country                                       |             |
      | Mobile phone                                  |             |
      | Assign an address alias for future reference. |             |
    And user clicks on "Register"
    Then "CREATE AN ACCOUNT" is displayed
    And user name is not displayed in Navigation bar
    And errors are displayed:
      | You must register at least one phone number.      |
      | lastname is invalid.                              |
      | firstname is invalid.                             |
      | email is invalid.                                 |
      | passwd is invalid.                                |
      | id_country is required.                           |
      | address1 is required.                             |
      | city is required.                                 |
      | Country cannot be loaded with address->id_country |
      | Country is invalid                                |