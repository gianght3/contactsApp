Feature: Edit contact
  Scenario: Show Edit contact screen after click edit button
    Given The home screen displays
    When The user attempt to select a contact to edit from the list
    Then The edit contact screen will be showed
    And The user should see the information in the edit screen the same the information of the contact