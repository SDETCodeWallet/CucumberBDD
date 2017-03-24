@Abhi 
Feature: Creating New Customer
	I want to use this template for my Creating_New_Customer Feature file

@positiveLoginScenario
Scenario: Successfully Login to the Application
Given User is Launching Browser
When User Navigate to Login Page
	 And User entered valid UserName 
	 And User entered valid UserPassword
Then Message displayed Login Successfully

@creatingNewCustomer
Scenario: Creating New Account
Given User click on New Customer link
When I read the excel file
Then I access worksheet
Then I access Rows and Cells
Then I convert the sheet data into hash with keys as column headers	
When I fill the form with data from excel	
Then I click on submit button
Then Message displayed customer  record created successfully