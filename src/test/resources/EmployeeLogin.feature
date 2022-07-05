#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Employee Login

Background:
    Given A Employee Is on LoginPage

  Scenario Outline: A Employee can Login using thier credentials
  
    
        When The Employee Types in Thier "<username>" and "<password>" and clicks the loginButton
    
    
        Then The employee should be on HomePage
    

    Examples: 
      | username  | password | 
      | johnj |     j123 |
      | thomasr |     t123 |
      | danF    | d123|
