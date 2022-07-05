package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.LoginPage;
import com.revature.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepsImplemnt {

	private static WebDriver driver =LoginRunner.driver;
	private LoginPage loginPage = LoginRunner.loginPage;
	
	@Given("A Employee Is on LoginPage")
	public void a_employee_is_on_login_page() {
	 driver.get("http://localhost:8080/LoginPage.html");  
  //driver.get("file:///C:/Users/khell/eclipse-workspace/khellil_merabet_Project_One/src/main/resources/public/LoginPage.html");
		
	}

	@When("The Employee Types in Thier {string} and {string} and clicks the loginButton")
	public void the_employee_types_in_thier_username_and_password_and_click_login_button(String username, String password) {
	 loginPage.usernameInput.sendKeys(username);
	 loginPage.passwordInput.sendKeys(password);
	 loginPage.loginButton.click();
	}

	@Then("The employee should be on HomePage")
	public void the_employee_should_be_on_home_paga() {
		
		// we need to incorporate a WAIT here....
				// here's an Explicit Wait
				new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.titleContains("Home Page"));
	  assertEquals("Home Page", driver.getTitle());  
	}
	
}
