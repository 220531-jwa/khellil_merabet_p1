package com.revature.models;

public class EmployeeRole {

	private int employeeId;
	private String role;
	
	public EmployeeRole () {
		
	}

	public EmployeeRole(int employeeId, String role) {
		super();
		this.employeeId = employeeId;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeRole [employeeId=" + employeeId + ", role=" + role + "]";
	}
	
	
}
