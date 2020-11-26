Feature: Search

  Background:
    Given I am on ebuyer home page

  Scenario: Search for a product
    When I enter a product 'Polycom VoiceStation 300 Analogue Conference Phone' into search field and click search
    Then quick find number is displayed