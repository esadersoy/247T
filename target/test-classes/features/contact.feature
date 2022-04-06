@All
Feature: Contacts Page

  Background:
    Given the user on login page
    When  the user enters valid email
    And   the user enters valid password
    And   the user clicks login button

  @login
  Scenario: Verify that login function is working properly
    And  the user navigate "https://app.247pro.com/dashboard"
    Then the user should be able to display welcome message
    Then the name of the user should be displayed on the page

  @contactsPage
  Scenario: Verify that the user can navigate contacts page
    When the user clicks menu button
    And  the user clicks "Contacts" from menu
    Then the user should be able to land on "Contacts" page

  @addContact
  Scenario Outline: Verify that the user can add new contact
    Given the user navigates contacts page
    When  the user clicks new contact button
    Then  the user should be able to display "Create Contact"
    And the user enters following inputs

      | contactType | <selectContactType> |
      | name        | <contactName>       |
      | Company     | <contactCompany>    |
      | title       | <contactTitle>      |
      | email       | <addEmail>          |
      | phone       | <addPhone>          |

    And the user clicks save button
    Then the new contact should be displayed on the table
    And the new user name should be displayed on "<selectContactType>" table

    Examples:
      | selectContactType | contactName  | contactCompany | contactTitle  | addEmail           | addPhone   |
      | Client            | Jason Bourne | AXES           | Developer     | jasonb@axes.com    | 2256338787 |
      | Vendor            | David Webb   | IBM            | SDET          | davidw@ibm.com     | 2414662121 |
      | Subcontractor     | Tom Hanks    | Hollywood inc. | Product Owner | tomh@hollywood.com | 2414662121 |

  @updateContact
  Scenario: Verify that the user can update information on contact
    Given the user navigates contacts page
    When the user clicks three dots button of selected contact "David Webb"
    And  the user clicks "Edit" button on the dialog
    Then "Edit Contact" dialog should be displayed
    When the user changes "Name" of contact with "Jennifer Green"
    When the user clicks on "Save"  button on the dialog
    Then the new user name should be displayed on "All" table


  @deleteContact
  Scenario: Verify that the user can delete contacts
    Given the user navigates contacts page
    When  the user clicks three dots button of selected contact "Jennifer Green"
    And   the user clicks "Delete" button on the dialog
    Then  "Confirm" dialog should be displayed
    When  the user clicks on "Confirm"  button on the dialog
    Then  the selected contact "Jennifer Green" should not be displayed on "All" table