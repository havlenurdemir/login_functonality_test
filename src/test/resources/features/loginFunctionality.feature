@TRAN10-281 @Regression @login
Feature:login feature
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

  @TRAN10-400
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

  @TRAN10-402
  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
    When user is on the translantik page
    And user enters "<username>" into username field
    And user enters "<password>" into password field
    Then "<message>" should be displayed

    @credentialsFill
    Examples: username and password
      | username | password    | message                   |
      |          | UserUser123 | Lütfen bu alanı doldurun. |
      | user1    |             | Lütfen bu alanı doldurun. |
      |          |             | Lütfen bu alanı doldurun. |

  @TRAN10-404
  Scenario: User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When user clicks on the "Forgot your password" link
    Then user should land on "Forgot Password" page

  @TRAN10-406
  Scenario: User can see "Remember Me" link exists and is clickable on the login page,
    When user clicks on the "Remember Me" button

  @TRAN10-408
  Scenario: User should see the password in bullet signs by default (like ****)
    When user types password "UserUser123"
    Then user should see the password in bullet signs

  @TRAN10-410
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When user types username "user1" and clicks enter
    And user types "UserUser123" and clicks enter
    Then user should land on the "Quick Launchpad" page

  @TRAN10-411
  Scenario: All users can see their own usernames in the profile menu, after successful login
    When user enters "user1" into username field
    And user enters "UserUser123" into password field
    Then user should see their own usernames in the profile







