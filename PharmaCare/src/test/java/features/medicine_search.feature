Feature: Search Medicine

  Scenario: Search for a medicine
    Given The patient is on the homepage
    When The patient enters "Aspirin" in the search box
    And clicks the "search" button
    Then The system shows all available medicines containing "Aspirin" in the name

  Scenario: Search for a non-existing medicine
    Given The patient is on the homepage
    When The patient enters "NonExistingMedicine" in the search box
    And clicks the "search" button
    Then The system shows no available medicines containing "NonExistingMedicine" in the name

  Scenario: Search for medicine with different case
    Given The patient is on the homepage
    When The patient enters "aspirin" in the search box
    And clicks the "search" button
    Then The system shows all available medicines containing "Aspirin" in the name

  Scenario: Search for partial medicine name
    Given The patient is on the homepage
    When The patient enters "Aspi" in the search box
    And clicks the "search" button
    Then The system shows all available medicines containing "Aspi" in the name

  Scenario: Search for medicines by category
    Given The patient is on the homepage
    When The patient selects the "Pain Relief" category
    And clicks the "search" button
    Then The system shows all available medicines in the "Pain Relief" category
