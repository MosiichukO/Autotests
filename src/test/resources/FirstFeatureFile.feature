Feature: Receive mail

  Scenario: Receive mail
    Given I open Main page
    And I click random name button
    And I click dropdown domain button
    And I wait for visibility of rover info domain element 10 seconds
    And I click rover info domain
    Then I check that choose @rover.info domain
    And I remember the email
    And I click settings button
    And I wait for visibility of secret address element 10 seconds
    And I remember the secret address
    And I click close settings button
    And I wait for visibility of drop down button element 10 seconds
    Then I check the settings modal window is closed
    Then I check waiting letters string is visible
    And I click write letter button
    And I wait for visibility of send button element 10 seconds
    And I write the letter to my email with theme - Test and body - my secret address
    And I click send letter button
    And I wait for visibility of new letter income element 10 seconds
    And I click new letter income
    And I wait for visibility of reply button element 10 seconds
    Then I check the components of email income
    And I click reply button
    And I write to body - TestTwo
    Then I wait 2 seconds
    And I click send letter button
    Then I wait 4 seconds
    And I click back button
    Then I wait 2 seconds
    Then I check letter with Re
    And I open last income letter
    Then I check the components of letter with Re
    And I delete the letter
    Then I check that Re letter is not exist