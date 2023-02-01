Feature: Test the login functionality

  @sanity @regression
  Scenario: Login with valid email and valid password using data driven from feature file
    Given user open the website and go to login page
    When user fill username as "tomsmith" and password as "SuperSecretPassword!" and click on login 01
    Then user should navigate to home page

  @regression
  Scenario: Login with valid email and valid password using data table
    Given user open the website and go to login page
    When user fill username and password and click on login 02
    | tomsmith | SuperSecretPassword! |
    Then user should navigate to home page


    @regression
    Scenario Outline: Login with invalid credentials Scenario out line
      Given user open the website and go to login page
      When user fill "<username>" and "<password>" and click on login 03
      Then user get error message
      Examples:
      |    username    |      password      |
      |      tom       |SuperSecretPassword!|
      |    tomsmith    |    SuperSecret     |
      |      tom       |    SuperSecret     |