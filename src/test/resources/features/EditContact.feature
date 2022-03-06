Feature: Edit contact
  Scenario: Show Edit contact screen after click edit button
    Given The home screen displays
    When The user attempt to select a contact to edit from the list
    Then The edit contact screen will be showed
    And The user should see the information in the edit screen the same the information of the contact

  Scenario: Show contact updated information screen after edit contact
    Given The edit contact screen is displayed
    When The user attempt to edit information of contact then save
    Then The user should see these updated information on contact detail
    And The action will be displayed for according contact's updated information

  Scenario: Show confirmation before close Edit contact with inputted information
    Given The edit contact screen is displayed
    When The user attempt to edit information of contact then cancel
    Then The message with content "Your changes have not been saved" will be showed with two option Discard and Save
    And The Edit contact will be closed for Discard option selected

  Scenario: The contact was edited for Save confirmation from cancellation popup confirm
    Given The edit contact screen is displayed
    When The user attempt to edit information of contact then cancel
    And The user agree with Save option selected
    Then The user should see these updated information on contact detail
    And The action will be displayed for according contact's updated information