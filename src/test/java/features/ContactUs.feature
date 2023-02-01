@sanity @regression @contactUse
Feature: contact us feature
  Scenario: check email field is visible
    Given user open the website
    When user click on contact sales button
    Then business email field should be visible
