Feature: Customer Transactions Tests

  Background:
    When Navigate to Login Page
    When Login with your name is "Harry Potter"

  Scenario: Customer deposits money with valid amount
    When Deposit Money with the amount is "123"
    Then The customer balance is "111"
    And Last customer transaction is shown correctly
      | amount | depositType |
      | 1      | a           |

  Scenario: Customer is unable to withdraw the money that exceed the balance
    When Withdraw Money with the amount is "123"
    Then The withdraw message should be shown "Transaction Failed. You can not withdraw amount more than the balance."
    Then The customer balance is "111"

  Scenario: Customer withdraws money with valid amount
    When Deposit Money with the amount is "123"
    When Withdraw Money with the amount is "123"
    Then The withdraw message should be shown "Transaction successful"
    And The customer balance is "111"
    And Last customer transaction is shown correctly
      | amount | depositType |
      | 1      | a           |

  Scenario: Customer resets the customer transactions
    When Deposit Money with the amount is "123"
    And Withdraw Money with the amount is "123"
    And Reset transactions
    Then The transactions list is empty