@TC-1
Feature: Verifying career functions

Scenario Outline: Validating career resume upload function with valid inputs
      Given User Launches the application
      When User Navigates to job opportunity via career header
      When User Selects the job priority in the job filter 
      And User Prints the listed jobs 
      When User Selects the software tester job
      And User Enters in the form "<firstName>","<lastName>","<email>","<mobile>","<noticePeriod>"
      Then User Validates the success message         
   
   Examples:
   |firstName|lastName|email              |mobile    |noticePeriod  |
   |karthik  |karthik |karthik@gmail.com  |8554174421|25-august-2023|
   