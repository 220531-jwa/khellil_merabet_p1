package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	public Employee createNewEmployee(Employee u) {

	String sql = "insert into Employee values (?, ?, ?, ?, ?, ?, ?) returning *";
		//String sql = "insert into Employee values (?, ?, ?, ?, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getEmployeeId());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getUsername());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getEmployeeRole());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee (
						rs.getInt("employeeid"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getString("email"),
						rs.getString("employeerole")
						);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Employee> getAllEmployee() {
		// create an empty array list that will hold all the users returned from the database
		List<Employee> employees = new ArrayList<>();
		
		// this is the sql statement that we'll be executing
		String sql = "select * from Employee";
		
		// try with resources - this will auto close any resources we need without a finally block
		try (Connection conn = cu.getConnection()) {
			// prepare our statement using the connection object
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// execute our statement and store the result set in a reference variable
			ResultSet rs = ps.executeQuery();
			
			// iterate over the result set, to get the values stored in each column and creating a Java Object with them
			while(rs.next()) {
				// use the getXXX() methods to retrieve the values stored in each column of this row of the result set
				int id = rs.getInt("employeeid");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				String email = rs.getString("email");
				String employeeRole = rs.getString("employeerole");
				
				
				Employee u = new Employee(id, firstName, lastName, username, password, email, employeeRole);
				
				employees.add(u);
			}
			return employees;
			
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return null;
	}
	
	public Employee getEmployeeById(int employeeid) {
		
		String sql = "select * from Employee where employeeid = ?"; // this question mark symbolizes and IN parameter for our statement
		
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeid); // here we are setting the the "?" in our sql string to be the int id that's passed in to this method as an argument
		
			ResultSet rs = ps.executeQuery();
			
			// if the result set has a row/record
			if (rs.next()) {
			return new Employee (
								rs.getInt("employeeid"),
								rs.getString("firstname"),
								rs.getString("lastname"),
								rs.getString("username"),
								rs.getString("pass"),
								rs.getString("email"),
								rs.getString("employeerole")
								);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; // Optional Class -> can help avoid NullPointer Exceptions (if any one is curious)
	}
	
	public Employee getUserByUsername(String username) {

String sql = "select * from Employee where username = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Employee(
						rs.getInt("employeeid"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getString("email"),
						rs.getString("employeerole")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public void updateEmployee(Employee uChange) {

		String sql = "update Employee set firstname = ?, lastname = ?, username = ?, pass = ?, email = ?, employeerole = ? where employeeid = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uChange.getFirstName());
			ps.setString(2, uChange.getLastName());
			ps.setString(3, uChange.getUsername());
			ps.setString(4, uChange.getPassword());
			ps.setString(5, uChange.getEmail());
			ps.setString(6, uChange.getEmployeeRole());
			//ps.setInt(7, uChange.getId());

			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteEmployee(int employeeid) {
		String sql = "delete from Employee where employeeid = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeid);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee updateEmployeePassword(int id, String password) {

		String sql = "update Employee set pass = ? where employeeid = ? returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(
						rs.getInt("employeeid"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getString("email"),
						rs.getString("employeerole")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
