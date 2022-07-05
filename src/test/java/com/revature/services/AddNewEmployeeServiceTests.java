package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.models.Employee;

import com.revature.repositories.EmployeeDAO;

public class AddNewEmployeeServiceTests {

	@InjectMocks
	EmployeeService employeeServiceMocks;
     // private static ReimbursementService reimbursementServiceMoks;
	
	@Mock
	EmployeeDAO employeeDaoMock;
	//private static ReimbursementDAO reimbursementDaoMock;
	

	@Test
	public void CreateNewEmployeeWithValidInput() {
// Given
		Employee mockEmployee = new Employee(1, "ali", "mass", "ajal", "option", "ali@gmail.com", "manager");
		//Reimbursement mockReimbursement = new Reimbursement();
// When
		when(employeeDaoMock.createNewEmployee(1, "ali", "mass", "ajal", "option", "ali@gmail.com", "manager"))
		//when(employeeDaoMock.createNewEmployee(employeeDaoMock))
		  .thenReturn(mockEmployee);
// Then
		Employee loggedInEmployee = employeeServiceMocks.createNewEmployee(1, "ali", "mass", "ajal", "option", "ali@gmail.com", "manager");

		assertEquals(mockEmployee, loggedInEmployee);


	}

	
	
	
}
