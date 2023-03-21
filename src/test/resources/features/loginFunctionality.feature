@TRAN10-281 @Regression @login
Feature: Library app login feature
  User Story :

  As a user, I should be able to log in

  Users are: Driver, Sales Manager, Store Manager

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the translantik page

  @TRAN10-380 @Driver @login
  Scenario: Driver should land on the "Quick Launchpad" page after successful login
    When user is on the translantik web page
    And user enters "user1" into username field
    And user enters "UserUser123" into password field
    Then user should land on the "Quick Launchpad" page

  @TRAN10-383 @SalesManager @login
  Scenario: Sales Manager should land on the "Dashboard" page after successful login
    When user is on the translantik web page
    And user enters "salesmanager101" into username field
    And user enters "UserUser123" into password field
    Then user should land on the "Dashboard" page

  @TRAN10-384 @StoreManager @login
  Scenario: Driver should land on the "Quick Launchpad" page after successful login
    When user is on the translantik web page
    And user enters "storemanager51" into username field
    And user enters "UserUser123" into password field
    Then user should land on the "Dashboard" page


  Scenario Outline: "Invalid username or password." should be displayed for invalid credentials
    When user is on the translantik web page
    And user enters "<username>" into username field
    And user enters "<password>" into password field
    Then user should land on the "Dashboard" page


    @credentials
    Examples: username and password credentials
      | username | password    | description                                 |
      | user1    | dsgkfskjg   | valid username - invalid password           |
      | USER1    | UserUser123 | uppercase valid username - invalid password |
      | hdfjhd   | gunvjfkuf   | invalid username - invalid password         |
      | gkcdbv   | UserUser123 | invalid username - valid password           |
      |          | UserUser123 | blank username - valid password             |
      | user1    |             | valid username -  blank password            |

  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
    When user is on the translantik page
    And user enters "<username>" into username field
    And user enters "<password>" into password field
    Then user should land on the "Dashboard" page

    @credentialsFill
    Examples: username and password
      | username | password    | description                     |
      |          | UserUser123 | blank username - valid password |
      | user1    |             | valid username - blank password |
      |          |             | blank username - blank password |




