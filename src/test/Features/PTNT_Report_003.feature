Feature: user Verify the view and download of cumulative report functionality of the system

  Background:
    Given the user navigate to the "https://patients.pathcare.co.za/" url
    And the user types "7810275800089" into  the "usernameTextfield" textField on "login_page" page
    And the user types "Systemtest@012024" into  the "passwordTextfield" textField on "login_page" page
    And the user clicks the "loginButton" button on "LoginPage" page
    And the verify that web element attribute "dashboard_headerText" action "contains" text "Welcome to the PathCare Patient Portal!" on "dashboard_page" page
  Scenario Outline:
    And the user clicks the "cumulative_btn" button on "dashboard_page" page
    And the user clicks the "pathcare_southafrica_btn" button on "dashboard_page" page
    And the verify that web element attribute "id_numbr" action "contains" text "<ID_number>" on "dashboard_page" page
    And the verify that web element attribute "user_name" action "contains" text "<Surname>" on "dashboard_page" page
    And the verify that web element attribute "fst_name" action "contains" text "<Firstname>" on "dashboard_page" page
    And the verify that web element attribute "email" action "contains" text "<Email>" on "dashboard_page" page
    And the verify that web element attribute "cell_num" action "contains" text "<Cellphone>" on "dashboard_page" page
    And the verify that web element attribute "default_practice_txt" action "contains" text "<Default_practice>" on "dashboard_page" page

    And the user clicks the "download_btn" button on "dashboard_page" page
    Examples:
      | ID_number     | Surname    | Firstname | Email                                 | Cellphone    | Default_practice |
      | 7810275800089 | FLINTSTONE | FRED      | tmpkceml.7810275800089@pathcare.co.za | 083 590 6677 |  PathCare South Africa                |


