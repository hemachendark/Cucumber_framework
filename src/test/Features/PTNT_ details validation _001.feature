Feature: Verify user details confirmation.

  Background:
    Given the user navigate to the "https://patients.pathcare.co.za/" url
    And the user types "7810275800089" into  the "usernameTextfield" textField on "login_page" page
    And the user types "Systemtest@012024" into  the "passwordTextfield" textField on "login_page" page
    And the user clicks the "loginButton" button on "LoginPage" page
    And the verify that web element attribute "dashboard_headerText" action "contains" text "Welcome to the PathCare Patient Portal!" on "dashboard_page" page
  Scenario Outline:
    And the user clicks the "my_profile_btn" button on "dashboard_page" page
    And the verify that web element attribute "dashboard_headerText" action "contains" text "Welcome to the PathCare Patient Portal!" on "dashboard_page" page

    And the user clicks the "pathcare_southafrica_btn" button on "dashboard_page" page
    And the user clicks the "download_btn" button on "dashboard_page" page
    Examples:
      |  |



