@Irina @run
Feature: SignUp

  Background:
    Given user is on Create Account page

  Scenario: SignUp with valid data
    When user enters data into fields:
      | First name                                    | John                     |
      | Last name                                     | Smitherson               |
      | Email                                         | random                   |
      | Password                                      | Ab12%                    |
      | First name from address                       | John                     |
      | Last name from address                        | Smitherson               |
      | Address                                       | Brunlich, 35001, Broenna |
      | City                                          | Carrley                  |
      | State                                         | Alabama                  |
      | Zip/Postal Code                               | 00000                    |
      | Country                                       | United States            |
      | Mobile phone                                  | 105454545                |
      | Assign an address alias for future reference. | Home address             |
    And user clicks on Register button
    Then My Account page is displayed
    And John Smitherson is displayed in Navigation bar

  Scenario: SignUp with invalid data
    When user enters data into fields:
      | First name                                    | Arr457        |
      | Last name                                     | 7Alkim        |
      | Email                                         | j.smithffg@   |
      | Password                                      | A1%           |
      | First name from address                       | Zery5         |
      | Last name from address                        |               |
      | Address                                       |               |
      | City                                          |               |
      | State                                         | -             |
      | Zip/Postal Code                               | 000           |
      | Country                                       | United States |
      | Mobile phone                                  |               |
      | Assign an address alias for future reference. |               |
    And user clicks on Register button
    Then Create Account page is displayed
    And Arr457 7Alkim is not displayed in Navigation bar
    And errors are displayed:
      | type             | message                                                                          |
      | Phone error      | You must register at least one phone number.                                     |
      | Last name error  | lastname is required.                                                            |
      | First name error | firstname is invalid.                                                            |
      | Password error   | passwd is invalid.                                                               |
      | Email error      | email is invalid.                                                                |
      | Alias error      | alias is required.                                                               |
      | Address error    | address1 is required.                                                            |
      | City error       | city is required.                                                                |
      | Zip error        | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
      | State error      | This country requires you to choose a State.                                     |