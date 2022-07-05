
Feature: Manager creating a new employee

Background:
    Given A Manager Is on AddNewEmployee Page

  Scenario Outline: A Manager can Fill up Employee information
  
    
        When The Manager Types in Thier "<employeeid>" and "<firstName>" and "<lastName>" and "<username>" and "<password>" and "<email>" and "<employeeRole>" and clicks the ADDButton
    
    
        Then The Manager should be on HomePage
    

    Examples: 
     | employeeid | firstname | lastName | username  | password | email | employeeRole | 
      | 2        | john      | jackson  | johnj     | j123   | john@revature.com | employee | 
       #| employeeId | firstname | lastName | username  | password | email | employeeRole | 
       #| employeeId | firstname | lastName | username  | password | email | employeeRole | 

