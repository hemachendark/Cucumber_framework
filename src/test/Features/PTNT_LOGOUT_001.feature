Feature: user Verify the logout functionality of the system

  Background:
    Given the user navigate to the "https://patients.pathcare.co.za/" url
    And the user types "7810275800089" into  the "usernameTextfield" textField on "login_page" page
    And the user types "Systemtest@012024" into  the "passwordTextfield" textField on "login_page" page
    And the user clicks the "loginButton" button on "LoginPage" page
    And the verify that web element attribute "dashboard_headerText" action "contains" text "Welcome to the PathCare Patient Portal!" on "dashboard_page" page

  Scenario:
    And the user clicks the "logged_out_button" button on "dashboard_page" page
