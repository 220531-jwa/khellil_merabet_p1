package com.revature.steps;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.LoginPage;
import com.revature.pages.SubmitingPage;
import com.revature.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitingReimbursementStepsImplmnt {

	private static WebDriver driver =LoginRunner.driver;
	//private LoginPage loginPage = LoginRunner.loginPage;
	

@Given("A Employee Is on Home Page to send a Reimbursement")
public void a_employee_is_on_home_page_to_send_a_reimbursement() {
	 driver.get("http://localhost:8080/RequestReimbursement.html");   
}

@When("The Employee enters Thier {string} and {string} and {string} and {string} and {string} and \"{int}\"and clicks the SubmitButton")
public void the_employee_enters_thier_and_and_and_and_and_and_clicks_the_submit_button(String string, String string2, String string3, 
		String string4, String string5, Integer int1) {
 
	//SubmitingPage.reimbursementIdInput.sendKeys("id");
	SubmitingPage.idEmployeeInput.sendKeys("employeeid");
	SubmitingPage.idDateInput.sendKeys("daterequested");
	SubmitingPage.idAmountInput.sendKeys("amount");
	SubmitingPage.reviewTextInput.sendKeys("description");
	SubmitingPage.idTypeofRInput.sendKeys("typeofrmbrsmnt");
	SubmitingPage.idStatusInput.sendKeys("status");
	
	SubmitingPage.Submit.click();
	
	 throw new io.cucumber.java.PendingException();
	
}

@Then("The employee should be Successful submit \\(His\\/Her) Reimbursement")
public void the_employee_should_be_successful_submit_his_her_reimbursement() {
  
	new WebDriverWait(driver, Duration.ofSeconds(30))
	.until(ExpectedConditions.titleContains("Home Page"));
assertEquals("Home Page", driver.getTitle());  
	
}
		
}
