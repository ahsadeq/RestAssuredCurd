Feature: Rest Assured Feature

  Scenario: To Verify the Get Operation
    Given I have the base URI "http://localhost:7000/employees"
    When I perform the Get Operation
    Then I should Get the response
    And Response Code Should be "200"   
