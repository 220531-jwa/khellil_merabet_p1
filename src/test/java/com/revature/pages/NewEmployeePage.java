package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEmployeePage {
	

private  WebDriver driver;
	
	public NewEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id = "idEmploy")
	public static WebElement employeeIdInput;
	
	@FindBy (id = "idFirstname")
	public static WebElement idFirstnameInput;
	
	@FindBy (id = "idLastname")
	public static WebElement idLastnameInput;
	
	@FindBy (id = "idUsername")
	public static WebElement idUsernameInput;
	
	@FindBy (id = "idPassword")
	public static WebElement idPasswordInput;
	
	@FindBy (id = "idEmail")
	public static WebElement idEmailInput;
	
	@FindBy (id = "idRole")
	public static WebElement idRoleInput;
	
	
	@FindBy (xpath = "/html/body/div/button")
	public static WebElement ADD;	
	///html/body/div/button

}
