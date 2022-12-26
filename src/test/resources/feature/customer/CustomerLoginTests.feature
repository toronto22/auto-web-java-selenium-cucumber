Feature: Customer Login Tests

  Background:
    When Navigate to Login Page

  Scenario: The Login button is hidden in default
    Then Login button is hidden

  Scenario: The Login Button Is Hidden When Deselect Your Name
    When Select Your Name "Harry Potter"
    And Select Your Name "---Your Name---"
    Then The Login button is displayed

  Scenario: The Login Button Is Shown When Select Your Name
    When Select Your Name "Harry Potter"
    Then The Login button is hidden

  Scenario: Login Successfully With Valid Credential
    When Login with your name is "Harry Potter"
    Then The Customer is logged in successfully