Feature: Viewing List Customer Tests

  Background:
    When Navigate to List Customer Page

  Scenario:  Manager view list customer table
    Then The list customer table should have "10" items

  Scenario: Manager create a new customer
    When Navigate to Add Customer page
    And Add customer
      | firstName | lastName | postCode |
      | firstName | lastName | postCode |
    And Navigate to Open Account Page
    And Open a new account
      | customerName | currency |
      | customerName | currency |
    And Close the open account alert
    And Navigate to List Customer Page
    Then The customer should be exist in list customers