Feature: Prescription Management

  Scenario: Create a new prescription with valid data
    Given The doctor is logged in
    When The doctor creates a new prescription with valid data for a patient
    Then The prescription is added to the system
    And The patient can see the new prescription in their profile

  Scenario: Create a new prescription with missing patient information
    Given The doctor is logged in
    When The doctor tries to create a new prescription with missing patient information
    Then The system shows an error message "Patient information is required"

  Scenario: Create a new prescription with invalid medication name
    Given The doctor is logged in
    When The doctor tries to create a new prescription with an invalid medication name
    Then The system shows an error message "Invalid medication name"

  Scenario: Create a new prescription with past date
    Given The doctor is logged in
    When The doctor tries to create a new prescription with a past date
    Then The system shows an error message "Prescription date cannot be in the past"

  Scenario: Create a new prescription with duplicate prescription for the same patient
    Given The doctor is logged in
    And There is an existing prescription for the patient
    When The doctor tries to create a duplicate prescription for the same patient
    Then The system shows an error message "Duplicate prescription"
