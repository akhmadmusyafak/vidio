@login
Feature: Login
  I want to use this template for my feature file

  @normal_login
  Scenario Outline: Login menggunakan hp nomor dan password valid
    Given I want to open vidio.com for <row>
    When I login

    Examples: 
      | row |
      |   2 |
