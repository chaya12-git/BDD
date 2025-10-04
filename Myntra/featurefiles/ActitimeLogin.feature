Feature: Login feature
  Scenario: Valid login to the application
    Given User should be present in "http://localhost/login.do"
    When he enters the username as "admin"
    And he enters the password as "manager"
    And he clicks on login button
    Then home page should be displayed

@Invalid
  Scenario Outline: Login using examples
    Given User should be present in "http://localhost/login.do"
    When he enters the username as "<username>"
    And he enters the password as "<password>"
    And he clicks on login button
    Then home page should be displayed
    Examples:
    |username|password|
    |admin|manager|
    |abc456|def789|
    |manager|admin|
