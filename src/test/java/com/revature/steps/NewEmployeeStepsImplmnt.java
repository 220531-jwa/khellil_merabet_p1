package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.NewEmployeePage;
import com.revature.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewEmployeeStepsImplmnt {
	private static WebDriver driver =LoginRunner.driver;

@Given("A Manager Is on AddNewEmployee Page")
public void a_manager_is_on_add_new_employee_page() {
	 driver.get("http://localhost:8080/AddNewEmployee.html"); 
	
}

@When("The Manager Types in Thier {string} and {string} and {string} and {string} and {string} and {string} and {string} and clicks the ADDButton")
public void the_manager_types_in_thier_and_and_and_and_and_and_and_clicks_the_add_button(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	NewEmployeePage.employeeIdInput.sendKeys("employeeid");
	NewEmployeePage.idFirstnameInput.sendKeys("firstName");
	NewEmployeePage.idLastnameInput.sendKeys("lastName");
	NewEmployeePage.idUsernameInput.sendKeys("username");
	NewEmployeePage.idPasswordInput.sendKeys("password");
	NewEmployeePage.idEmailInput.sendKeys("email");
	NewEmployeePage.idRoleInput.sendKeys("employeeRole");
	
	NewEmployeePage.ADD.click();
	
}

@Then("The Manager should be on HomePage")
public void the_manager_should_be_on_home_page() {
 
	new WebDriverWait(driver, Duration.ofSeconds(30))
	.until(ExpectedConditions.titleContains("Home Page"));
assertEquals("Home Page", driver.getTitle());  
	
}

	
}
