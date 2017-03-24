package com.cucumber.stepdefinitions;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.runner.RunCukesTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_New_Customer_Test_Steps {

	
	
	
	public static Workbook workbookObj;
	public WebDriver DriverObject;
	String baseURL = "http://demo.guru99.com/V4/";
	String expectedAlertMSG="You Have Succesfully Logged Out!!";
	String arg1="Test_Data_Sheet.xlsx";
	
	/*public Create_New_Customer_Test_Steps (){
		
		DriverObject=Hooks.driver;
		
	}*/
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		/*DriverObject = new FirefoxDriver();
		DriverObject.get(baseURL);
		DriverObject.manage().window().maximize();
		DriverObject.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement userName = DriverObject.findElement(By.name("uid"));
		userName.sendKeys("mngr64085");
		WebElement userPassword = DriverObject.findElement(By.name("password"));
		userPassword.sendKeys("Aruhuve");
		WebElement loginBTN = DriverObject.findElement(By.name("btnLogin"));
		loginBTN.click();	
		Thread.sleep(2000);*/
		/*DriverObject.findElement(By.xpath("//ul[@class='menusubnav']//li[2]/a")).click();*/
	    
	}

	@When("^User click on New Customer link$")
	public void user_click_on_New_Customer_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
//		 newCustomerLink.click();
		DriverObject.findElement(By.xpath("//ul[@class='menusubnav']//li[2]/a")).click();
	}

	@When("^I read the excel file$")
	public void i_read_the_excel_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		workbookObj = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"//"+"src//test//resources//"+arg1));
		Sheet sheet = workbookObj.getSheet("CustomerDetails");
	}

	@Then("^I access worksheet$")
	public void i_access_worksheet() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Sheet sheet = workbookObj.getSheet("CustomerDetails");
	}

	@Then("^I access Rows and Cells$")
	public void i_access_Rows_and_Cells() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Sheet sheet = workbookObj.getSheet("CustomerDetails");
        for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
        {
            Row currentRow = sheet.getRow(i);
            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
            {
                Cell currentCell = currentRow.getCell(j);
                switch (currentCell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(currentCell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(currentCell.getNumericCellValue() + "\t");
                        break;
                }
            }
            System.out.println("\n");

        }
	}

	@Then("^I convert the sheet data into hash with keys as column headers$")
	public void i_convert_the_sheet_data_into_hash_with_keys_as_column_headers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
         Sheet sheet = workbookObj.getSheet("CustomerDetails");
         Row HeaderRow = sheet.getRow(0);
         for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
             Row currentRow = sheet.getRow(i);
             HashMap<String, String> currentHash = new HashMap<String, String>();
             for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                 Cell currentCell = currentRow.getCell(j);
                 switch (currentCell.getCellType()) {
                     case Cell.CELL_TYPE_STRING:
                         currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                         break;
                     case Cell.CELL_TYPE_NUMERIC:
                         currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
                         break;
                 }

             }
             mydata.add(currentHash);
         }

         for (HashMap<String, String> h : mydata) {
             for (String key : h.keySet()) {
                 System.out.println(key + "\t" + h.get(key));
             }
             System.out.println("\n");
         }
	}

	@When("^I fill the form with data from excel$")
	public void i_fill_the_form_with_data_from_excel() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Sheet sheet = workbookObj.getSheet("CustomerDetails");

		DriverObject.findElement(By.name("name")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());   //WebElement custName = 
//		custName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
		
	}

	@Then("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


	@Then("^Message displayed customer  record created successfully$")
	public void message_displayed_customer_record_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		   Alert alertObj;
		   String alertMSG = DriverObject.switchTo().alert().getText();
		   if(alertMSG.equalsIgnoreCase(expectedAlertMSG)){
			   
			   System.out.println("User logged out successfully");
		   }
		   
		   DriverObject.switchTo().alert().accept();
		   DriverObject.quit();
		
	}
		
		
}
