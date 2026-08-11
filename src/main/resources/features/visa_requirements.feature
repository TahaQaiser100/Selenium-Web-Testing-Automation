Feature: Determine UK visa requirements

  As an international traveller
  I want to check whether I need a visa to enter the UK
  So that I know whether I need permission to travel

  Background:
    Given I navigate to the GOV.UK Check if you need a visa website
    And I start the visa eligibility assessment

  @Happy
  Scenario Outline: Determine visa requirements based on nationality and travel purpose
    When I select passport nationality "<Nationality>"
    And I select answer dual nationality as "<DualNationality>"
    And I select travel reason "<Reason>"
    Then I should be informed whether I need a visa

    Examples:
      | Nationality | DualNationality | Reason                                         |
      | Australia   | no              | Have medical treatment                         |
      | Burundi     | no              | Get married or enter into a civil partnership  |


    @Sad
    Scenario: User receives an error when nationality is not selected
      When I do not select a nationality
      And I click continue
      Then I should see an error show up

