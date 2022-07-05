package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	//private static UserDAO userDao = new UserDAO();
	
	
	private static EmployeeDAO employeeDao;
	
	public EmployeeService(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	//login
	public Employee login(String username, String password) {
		
		Employee u = employeeDao.getUserByUsername(username);
		
		if (u.getPassword().equals(password)) {
			return u;
		}
		return null;
	}
	
	public Employee updateEmployeePassword(int employeeid, String password) {
		// check if that user exists
		return employeeDao.updateEmployeePassword(employeeid, password);
	}
	
	// register / create user
	public Employee createEmployee(Employee u) {
		Employee createdEmployee = employeeDao.createNewEmployee(u);
		return createdEmployee;
	}

	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	public Employee getEmployeeById(int employeeid) throws Exception {
		// this is where you could put some business logic 
		// for example checking if the User returned by userDao.getUserById(id) is null 
		Employee u = employeeDao.getEmployeeById(employeeid);
		
		if (u == null) {
			throw new Exception("Employee not found");
		}
		
		return u;
	}

	public void deleteEmployee(int employeeid) {
		employeeDao.deleteEmployee(employeeid);
	}
	
	public void updateEmployee(Employee uChanged) {
		employeeDao.updateEmployee(uChanged);
	}


	
}
