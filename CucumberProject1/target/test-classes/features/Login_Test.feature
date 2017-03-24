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
@Abhi 
Feature: Validating Login Action
	I want to use this template for my Login_Test Feature file

@positiveLoginScenario
Scenario: Successfully Login to the Application
Given User is Launching Browser
When User Navigate to Login Page
	And User entered valid UserName 
	And User entered valid UserPassword
Then Message displayed Login Successfully

@onHomePage
Scenario: Verifying Home Page 
When User makes collection of links
Then Verifying the Links on HomePage


@tag4
Scenario: Successfully Logout 
When User LogOut from the Application 
Then Message displayed LogOut Successfully

