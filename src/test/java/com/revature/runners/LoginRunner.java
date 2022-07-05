package com.revature.runners;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.LoginPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;



//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources", glue = "com.revature.steps")


@Suite
public class LoginRunner {

	public static WebDriver driver;
	public static LoginPage loginPage;

	@BeforeAll
	public static void setup() {

		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();

		loginPage = new LoginPage(driver);
	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}

}