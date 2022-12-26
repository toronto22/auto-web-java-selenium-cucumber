Feature: Viewing Customer Account Tests

  Background:
    When Navigate to Login Page
    And Login with your name is "Harry Potter"

  Scenario:  customerViewsAccountInformationDetails
    Then The Customer Information should be shown
      | customerName | accountNumber | balance | currency |
      | 1            | 1             | 1       | 1        |

  Scenario:  customerViewsAccountInformationDetails
    When Select the account "Dollar"
    Then The Customer Information should be shown
      | customerName | accountNumber | balance | currency |
      | 1            | 1             | 1       | 1        |