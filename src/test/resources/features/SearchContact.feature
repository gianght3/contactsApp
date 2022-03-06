Feature: Search Contact
  Scenario: Show the list of suggest search for contact
    Given The home screen displays
    When The user attempt to search a existed contact
    Then The user should see this contact from contact list

  Scenario: Show the list of results search for contact
    Given The home screen displays
    When The user attempt to search a existed contact then enter
    Then The user should see this contact from contact list

  Scenario: Search with no results
    Given The home screen displays
    When The user attempt to search an inexistent contact then enter
    Then The user should see this message "No results"

  Scenario: Show Detail Contact screen after tap on specific contact from the list of suggest search
    Given The home screen displays
    When The user attempt to search a existed contact
    And The user attempt to view a contact detail from list of contact searched
    Then The detail contact screen should be showed

  Scenario:Show Detail Contact screen after tap on specific contact from the list of results search
    Given The home screen displays
    When The user attempt to search a existed contact then enter
    And The user attempt to view a contact detail from list of contact searched
    Then The detail contact screen should be showed

