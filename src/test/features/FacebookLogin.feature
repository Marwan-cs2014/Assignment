@FacebookLogin
Feature: Automation test for Facebook.com site

  Scenario: Login to Facebook (positive scenario)
    Given Navigate to Facebook site
    When Login with valid username "marwan_saadeh@payfort.com" and password "test1234"
    Then Will redirect to the user home page

  Scenario Outline: Login to Facebook (negative scenarios)
    Given Navigate to Facebook site
    When User try to login with <Username> username and <Passwprd> password
    Then <Validation message> Validation message should be displayed

    Examples: 
      | Username                  | Passwprd | Validation message                                                          |
      |                           |          | no                                                                          |
      | marwan_saadeh@payfort.com |          | The password you’ve entered is incorrect. Forgot Password?                  |
      | marwan_saadeh@payfort.com | testtest | The password you’ve entered is incorrect. Forgot Password?                  |
      | marwan_saadeh@wrong.com   |          | The email you’ve entered doesn’t match any account. Sign up for an account. |
      | marwan_saadeh@wrong.com   | testtest | The email you’ve entered doesn’t match any account. Sign up for an account. |
      |                           | testtest | no                                                                          |
