@kiwisaver
Feature: KiwiSaver Retirement Calculator
  I want to check the information icon in the KiwiSaver and to calculate projected balance at retirement

 @regression
  Scenario Outline: KiwiSaver - Information icon
    Given User is on KiwiSaver Calculator Page
    When User clicks Information icon next to "<Field>" field
    Then The message should be displayed for the user to enter the correct information in the "<Field>"

    Examples: 
      | Field                      |
      | Current Age                |
      | Employment status          |
      | Current KiwiSaver balance  |
      | Voluntary contributions    |
      | Risk profile               |
      | Savings goal at retirement |

  @regression @smoke
  Scenario: KiwiSaver Calculation at retirement for Employed Users
    Given User is on KiwiSaver Calculator Page
    When User enters age "30" employment status "Employed" salary "82000" kiwiSaverPercent "4%" risk profile "Defensive"
    Then Projected Balance at retirement should be displayed
    
 @regression
  Scenario Outline: KiwiSaver Calculation at retirement for Self Employed and Not Employed Users
    Given User is on KiwiSaver Calculator Page
    When User enters the below information
      | Age               | <Age>               |
      | Employment Status | <Employment Status> |
      | KiwiSaver Balance | <KiwiSaver Balance> |
      | Contribution      | <Contribution>      |
      | Frequency         | <Frequency>         |
      | Risk Profile      | <Risk Profile>      |
      | Goal              | <Goal>              |
    Then Projected Balance at retirement should be displayed

    Examples: 
      | Age | Employment Status | KiwiSaver Balance | Contribution | Frequency   | Risk Profile | Goal    |
      |  45 | Self-employed     | $100000           | $90          | Fortnightly | Conservative | $290000 |
      |  55 | Not employed      | $140000           | $10          | Annually    | Balanced     | $200000 |
    