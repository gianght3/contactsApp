Feature: Create Contact
  Scenario: Show contact detail screen after created.
    Given The Create contact on Device source is displayed
    When The user attempt to add a new contact
    Then The user should see these information on contact detail
    And The action will be displayed for according contact's information