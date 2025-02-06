Feature: user  Verify the view and download of episode report functionality of the system

  Background:
    Given the user navigate to the "https://patients.pathcare.co.za/" url
    And the user types "7810275800089" into  the "usernameTextfield" textField on "login_page" page
    And the user types "Systemtest@012024" into  the "passwordTextfield" textField on "login_page" page
    And the user clicks the "loginButton" button on "LoginPage" page
    And the verify that web element attribute "dashboard_headerText" action "contains" text "Welcome to the PathCare Patient Portal!" on "dashboard_page" page
  Scenario:
    And the user clicks the "my_results_button" button on "dashboard_page" page
    And the verify that web element attribute "my_results_page_headertxt" action "contains" text "<Pathology Results>" on "dashboard_page" page
    And the user clicks the "load_report_btn" button on "dashboard_page" page
    And the user clicks the "download_btn" button on "dashboard_page" page



