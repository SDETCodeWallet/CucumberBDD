package com.cucumber.stepdefinitions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.runner.RunCukesTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidLogin_Test_Steps {
	
	public static WebDriver DriverObject=RunCukesTest.DriverObj;
	String baseURL = "http://demo.guru99.com/V4/";
	String expecetdTitle,actualTitle;
	String xPath="//ul[@class='menusubnav']//li";
	String regSuccessMSG = "Customer Registered Successfully!!!";
	String expectedAlertMSG ="You Have Succesfully Logged Out!!";
	
	@Given("^User is Launching Browser$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DriverObject = new FirefoxDriver();
	  
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DriverObject.get(baseURL);
		DriverObject.manage().window().maximize();
		DriverObject.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	}

	@When("^User entered valid UserName$")
	public void user_entered_valid_UserName() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userName = DriverObject.findElement(By.name("uid"));
		userName.sendKeys("mngr69182");
		
	}

	@When("^User entered valid UserPassword$")
	public void user_enterde_valid_UserPassword() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement userPassword = DriverObject.findElement(By.name("password"));
		userPassword.sendKeys("mYpYtEz");
		WebElement loginBTN = DriverObject.findElement(By.name("btnLogin"));
		loginBTN.click();	
	    
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("Login Successfully");
		Thread.sleep(2000);
	    
	}
	
	@When("^User makes collection of links$")
	public void user_makes_collection_of_links() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> allLinks = DriverObject.findElements(By.xpath(xPath));//

	    int allLinkscnt = allLinks.size();
	    System.out.println("Total home page links are: " + allLinkscnt);
	   
	}

	@Then("^Verifying the Links on HomePage$")
	public void verifying_the_Links_on_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> allLinks = DriverObject.findElements(By.xpath(xPath));//

	    int allLinkscnt = allLinks.size();
	    Actions actObj = new Actions(DriverObject);
	    for(int i=0;i<=allLinkscnt-1;i++){
	    	
	    	allLinks = DriverObject.findElements(By.xpath(xPath)); //for updating list
	        Thread.sleep(30);

	        WebElement allLinks_WE = allLinks.get(i);
	        actObj.moveToElement(allLinks_WE).build().perform();
	        String str = allLinks_WE.getText();
	        System.out.println("Home Link No: " + i + "-" + str);
	    	
	    }
	    
	    System.out.println("Links Verified Successfully");
		
	}
	
	
	@When("^User click on New Customer Link$")
	public void user_click_on_New_Customer_Link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   WebElement newCustomerLink =  DriverObject.findElement(By.xpath("//ul[@class='menusubnav']//li[2]/a"));
	   newCustomerLink.click();
	}

	@When("^User entered details of new Customer$")
	public void user_entered_details_of_new_Customer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	   WebElement custName = DriverObject.findElement(By.name("name"));
	   custName.sendKeys("Aashank Srivastava");
	   WebElement maleRadioBTN = DriverObject.findElement(By.xpath("//input[@value='m']"));
	   maleRadioBTN.click();
	   WebElement custDOB = DriverObject.findElement(By.name("dob"));
	   custDOB.sendKeys("24/10/2013");
	   WebElement custADD = DriverObject.findElement(By.name("addr"));
	   custADD.sendKeys("35 Shanti Vihar Colony");
	   WebElement custCity = DriverObject.findElement(By.name("city"));
	   custCity.sendKeys("Varanasi");
	   WebElement custState = DriverObject.findElement(By.name("state"));
	   custState.sendKeys("UTTAR PRADESH");
	   WebElement custStatePINNo = DriverObject.findElement(By.name("pinno"));
	   custStatePINNo.sendKeys("221305");
	   WebElement custPhoneNo = DriverObject.findElement(By.name("telephoneno"));
	   custPhoneNo.sendKeys("7398831234");
	   WebElement custEmailID = DriverObject.findElement(By.name("emailid"));
	   custEmailID.sendKeys("aashank240813@gmail.com");
	   WebElement custPassword = DriverObject.findElement(By.name("password"));
	   custPassword.sendKeys("12345678");
	   WebElement submitBTN = DriverObject.findElement(By.name("sub"));
	   submitBTN.click();
	   Thread.sleep(2000);
	}

	@Then("^Verifying new customer has been created$")
	public void verifying_new_customer_has_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement regMSG_WE = DriverObject.findElement(By.xpath("//table[@id='customer']/tbody//tr[1]/td"));
	    String regMSGStr = regMSG_WE.getText();
	    if(regMSGStr.equalsIgnoreCase(regSuccessMSG)){
	    	WebElement custID_WE = DriverObject.findElement(By.xpath("//table[@id='customer']/tbody//tr[4]//td[2]"));
	 	    String custIDINT = custID_WE.getText();
	    	System.out.println("Customer Registered Successfully.");
	    	System.out.println("New Customer ID is: " +custIDINT);
	    	
	    }
	}

	
	
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement logOutLINK = DriverObject.findElement(By.xpath("//ul[@class='menusubnav']//li[15]/a"));
		logOutLINK.click();
	    
	}
	

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   Alert alertObj;
		   String alertMSG = DriverObject.switchTo().alert().getText();
		   if(alertMSG.equalsIgnoreCase(expectedAlertMSG)){
			   
			   System.out.println(alertMSG);
		   }
		   
		   DriverObject.switchTo().alert().accept();
		DriverObject.quit();
		
	}
	

}
