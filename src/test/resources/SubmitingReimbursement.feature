
Feature: Submiting Reimbursement
  
Background:
    Given A Employee Is on Home Page to send a Reimbursement

  Scenario Outline: A Employee can send a Reimbursement
  
    
        When The Employee enters Thier "<employeeid>" and "<daterequested>" and "<amount>" and "<description>" and "<typeofrmbrsmt>" and "<status>"and clicks the Submit
    
    
        Then The employee should be Successful submit (His/Her) Reimbursement
    

    Examples: 
      | employeeid  | daterequested | amount | description | status | typeofrmbrsmnt |
      | 3           | 2022-06-30    | 1700   | presentation | 1      |  2      |     
     
