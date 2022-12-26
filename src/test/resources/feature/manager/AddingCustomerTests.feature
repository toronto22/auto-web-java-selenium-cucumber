Feature: Adding Customer Tests

  Background:
    When Navigate to add customer page

  Scenario:  managerAddsCustomerWithValidCustomerInformation
    When Add customer
      | firstName | lastName | postCode |
      | firstName | lastName | postCode |
    Then It should be show the alert about customer is added
    When Close the alert
    And Navigate to Login Page
    And Login with your name is "Harry Potter"
    Then The Customer is logged in successfully

  Scenario Outline:  managerIsUnableToAddCustomerWithoutMandatoryField
    When Add customer
      | firstName   | lastName   | postCode   |
      | <firstName> | <lastName> | <postCode> |
    Then Error message should be shown "Please fill out this field."

    Examples:
      | firstName | lastName | postCode |
      |           | lastName | postCode |
      | firstName |          | postCode |
      | firstName | lastName |          |