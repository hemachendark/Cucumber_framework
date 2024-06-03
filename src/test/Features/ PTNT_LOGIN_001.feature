Feature: Verify the login functionality of the system using valid credentials
  Scenario Outline:
    Given the user navigate to the "<url>" url
    And the user types "username_textfield" into  the "<username>" textField on "login_page" page
    And the user types "password_textfield" into  the "<password>" textField on "login_page" page
    And the user clicks the "sign_in_button" button on "login_page" page
    And the verify that web element attribute "dashboard_textfield" action "contains" text "<headerText>" on "dashboard_page" page

    Examples:
      | url                              | username      | password          | headerText                              |
      | https://patients.pathcare.co.za/ | 7810275800089 | Systemtest@012024 | Welcome to the PathCare Patient Portal! |
