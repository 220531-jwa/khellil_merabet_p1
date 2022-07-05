package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {

	private static Logger log = LogManager.getLogger(EmployeeController.class);
	
	
	private EmployeeService es;
	
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
	public void loginEmployee(Context ctx) {
		Employee u = ctx.bodyAsClass(Employee.class);
		Employee loggedInEmployee = es.login(u.getUsername(), u.getPassword());
		ctx.json(loggedInEmployee);
		log.info("Session Attribute set for Employee" + loggedInEmployee);
	}
	//==============
	public void getAllEmployee(Context ctx) {
		log.info("Get Request recieved at endpoint /employees");
		ctx.status(200);
		List<Employee> employees = es.getAllEmployee();
		ctx.json(employees);
	}
	//==============
	public void createNewEmployee(Context ctx) {
		log.info("Creating New employee");
		ctx.status(201);
		Employee employeeFromRequestBody = ctx.bodyAsClass(Employee.class);
		Employee u = es.createEmployee(employeeFromRequestBody); // unmarshalling
		ctx.json(u);
	}
	//==============
	public void getEmployeeById(Context ctx) {
		int employeeid = Integer.parseInt(ctx.pathParam("employeeid"));
		Employee u = null;
		try {
			u = es.getEmployeeById(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			log.error("Employee with id of " + employeeid + " attempted to login, but does not exist.");
			ctx.status(404);
		}
		
	}
	//==============
	public void deleteEmployee(Context ctx) {
		int employeeid = Integer.parseInt(ctx.pathParam("employeeid"));
		es.deleteEmployee(employeeid);
	}
	//==============
	public void updateEmployee(Context ctx) {
		Employee uChanged = ctx.bodyAsClass(Employee.class); //unmarshalling
		System.out.println("updateEmployee -= " + uChanged);
		es.updateEmployee(uChanged);
	}
	//==============
	public void updatePassword(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Employee u = ctx.bodyAsClass(Employee.class); // {"password": "newPassword"}
		System.out.println(u.getPassword());
		es.updateEmployeePassword(id, u.getPassword());
	}
	
}
