Feature: Opening Account Tests

  Background:
    When Navigate to Open Account Page

  Scenario:  Manager open account for the customer
    When Open a new account
      | customerName | currency |
      | customerName | currency |
    Then Account is open successfully
    When Close the open account alert
    And Navigate to Login Page
    And Login with your name is "Harry Potter"
    Then The customer should have the new account

  Scenario Outline:  Manager open account with empty mandatory field
    When Open a new account
      | customerName   | currency   |
      | <customerName> | <currency> |
    Then The error message should be shown "Please select an item in the list."
    Examples:
      | customerName | currency |
      |              | currency |
      | customerName |          |
