@Abhi 
Feature: Validating Invalid Login Action
	I want to use this template for my Login_Test Feature file

@negativeLoginScenario
Scenario Outline: Invalid Login to the Application
Given User is Launching Browser
When User Navigate to Login Page
	And User entered invalid user Name as "User1"
	And User entered invalid user Password as "Password1"
Then Message displayed Login error

Examples:
|	userName	|	userPassword     |
|	user1	|	password123		 |