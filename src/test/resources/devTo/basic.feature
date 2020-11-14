Feature: Redirection
  Scenario: Redirection to week page
    Given I am on the devTo main page
    When I click on week button
    Then I should be redirected to "week" page
  Scenario: Redirection to month page
    Given I am on the devTo main page
    When I click on month button
    Then I should be redirected to "month" page
  Scenario: Select first podcast from podcasts
    Given I am on the devTo main page
    When I go to podcasts page
    And I select the first podcast from list
    Then I should be redirected to valid podcast page
  Scenario: Podcast is played
    Given I am on the devTo main page
    When I go to podcasts page
    And I select the first podcast from list
    And I play the podcast
    Then Podcast should be played



