package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitingPage {

private  WebDriver driver;
	
	public SubmitingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "idname")
	public static WebElement reimbursementIdInput;
	
	@FindBy (id = "idEmployee")
	public static WebElement idEmployeeInput;
	
	@FindBy (id = "idDate")
	public static WebElement idDateInput;
	
	@FindBy (id = "idAmount")
	public static WebElement idAmountInput;
	
	@FindBy (id = "reviewText")
	public static WebElement reviewTextInput;
	
	@FindBy (id = "idStatus")
	public static WebElement idStatusInput;
	
	@FindBy (id = "idTypeofR")
	public static WebElement idTypeofRInput;
	
	
	@FindBy (xpath = "/html/body/div/button")
	public static WebElement Submit;	
	///html/body/div/button
	
}
