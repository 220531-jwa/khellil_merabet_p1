package com.revature.models;

import java.util.Objects;

public class Employee {
		
		private int employeeId;
		private String firstName;
		private String lastName;
		private String username;
		private String password;
		private String email;
		private String employeeRole;
		
		public Employee() {
			
		}
		
		public Employee(int employeeId, String firstName, String lastName, String username, String password,
				String email, String employeeRole) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.email = email;
			this.employeeRole = employeeRole;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEmployeeRole() {
			return employeeRole;
		}

		public void setEmployeeRole(String employeeRole) {
			this.employeeRole = employeeRole;
		}
		
		
	
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", username=" + username + ", password=" + password + ", email=" + email + ", employeeRole="
					+ employeeRole + "]";
		}
	
		
		
		
}
