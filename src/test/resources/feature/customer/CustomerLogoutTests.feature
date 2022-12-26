Feature: Customer Logout Tests

  Background:
    When Navigate to Login Page
    When Login with your name is "Harry Potter"

  Scenario:  Customer Log Out Successfully From Account Page
    When Navigate to Account Page
    When Customer logout of application
    Then Customer Login page is active

  Scenario:  Customer Log Out Successfully From Transaction Page
    When Navigate to Customer Transaction Page
    When Customer logout of application
    Then Customer Login page is active