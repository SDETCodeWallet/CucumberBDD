package com.cucumber.stepdefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.runner.RunCukesTest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidLogin_Login_Steps {
	
    WebDriver DriverObject=RunCukesTest.DriverObj;
	String baseURL = "http://demo.guru99.com/V4/";
	String expectedAlertMSG = "User or Password is not valid";

	
	
/*	@When("^User entered invalid user Name as abhi$")
	public void user_entered_invalid_user_Name_as_abhi() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = DriverObject.findElement(By.name("uid"));
		username.sendKeys();
	}

	@When("^User entered invalid user Password as password(\\d+)$")
	public void user_entered_invalid_user_Password_as_password(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userpassword = DriverObject.findElement(By.name("password"));
		userpassword.sendKeys();
		WebElement loginBTN = DriverObject.findElement(By.name("btnLogin"));
		loginBTN.click();
	}*/
	
	@When("^User entered invalid user Name as \"([^\"]*)\"$")
	public void user_entered_invalid_user_Name_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement username = DriverObject.findElement(By.name("uid"));
		username.sendKeys();
	}

	@When("^User entered invalid user Password as \"([^\"]*)\"$")
	public void user_entered_invalid_user_Password_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userpassword = DriverObject.findElement(By.name("password"));
		userpassword.sendKeys();
		WebElement loginBTN = DriverObject.findElement(By.name("btnLogin"));
		loginBTN.click();
	}




	@Then("^Message displayed Login error$")
	public void message_displayed_Login_error() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Alert alertObj;
	   String alertMSG = DriverObject.switchTo().alert().getText();
	   if(alertMSG.equalsIgnoreCase(expectedAlertMSG)){
		   
		   System.out.println("User credentials are invalid.");
	   }
	   
	   DriverObject.switchTo().alert().accept();
	   DriverObject.quit();
	}

	
	
}
