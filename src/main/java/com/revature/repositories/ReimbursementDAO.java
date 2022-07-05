package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import io.cucumber.java.it.Date;

public class ReimbursementDAO {

	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// create New Reimbursement
	public Reimbursement createNewReimbursement(Reimbursement u) {

	//String sql = "insert into Reimbursement values (?, ?, now(), ?, ?, ?, ?) returning *";
	String sql = "insert into Reimbursement values (?, ?, ?, ?, ?, ?, ?) returning *";
		//String sql = "insert into Employee values (default, ?, ?, ?, ?, ?, ?) returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, u.getId());
			ps.setInt(2, u.getEmployeeId());
			ps.setString(3, u.getDateRequested());
			ps.setInt(4, u.getAmount());
			ps.setString(5, u.getDescription());
			ps.setInt(6, u.getStatus());
			ps.setInt(7, u.getTypeOfRmbrsmt());
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Reimbursement (
						rs.getInt("id"),
						rs.getInt("employeeid"),
						rs.getString("daterequested"),
						rs.getInt("amount"),
						rs.getString("description"),
						rs.getInt("status"),
						rs.getInt("typeofrmbrsmt")
						);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Select all Reimbursement
		public List <Reimbursement> selectAllReimbursement() {
		
				// create an empty array list that will hold all the users returned from the database
				List<Reimbursement> reimbursements = new ArrayList<>();

		String sql = "select * from Reimbursement order by employeeid";
			
		// try with resources - this will auto close any resources we need without a finally block
				try (Connection conn = cu.getConnection()) {
					// prepare our statement using the connection object
					PreparedStatement ps = conn.prepareStatement(sql);
					
					// execute our statement and store the result set in a reference variable
					ResultSet rs = ps.executeQuery();
					
					// iterate over the result set, to get the values stored in each column and creating a Java Object with them
					while(rs.next()) {
						// use the getXXX() methods to retrieve the values stored in each column of this row of the result set
						int id = rs.getInt("id");
						int employeeId = rs.getInt("employeeid");
						//Date dateRequested = (Date) rs.getDate("daterequested");
						String dateRequested = rs.getString("daterequested");
						int amount = rs.getInt("amount"); 
						String description = rs.getString("description");
						int status = rs.getInt("status");
						int typeOfRmbrsmt = rs.getInt("typeofrmbrsmt");
						
						Reimbursement r = new Reimbursement(id, employeeId, dateRequested, amount, description, status, typeOfRmbrsmt);
						//Reimbursement r = new Reimbursement();
						
						reimbursements.add(r);
					}
					return reimbursements;
		

			        } catch (SQLException e) {
				        e.printStackTrace();
			}

			return null;
		}
		
		// Select all Reimbursement by employeeId
		public Reimbursement getReimbursementById(int employeeid) {
			
			String sql = "select * from Reimbursement where employeeid = ?"; // this question mark symbolizes and IN parameter for our statement
			
			try (Connection conn = cu.getConnection()) {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, employeeid); // here we are setting the the "?" in our sql string to be the int id that's passed in to this method as an argument
			
				ResultSet rs = ps.executeQuery();
				
				// if the result set has a row/record
				if (rs.next()) {
				return new Reimbursement (
								    rs.getInt ("id"),
						            rs.getInt("employeeid"),
									rs.getString("daterequested"),
									rs.getInt("amount"),
									rs.getString("description"),
									rs.getInt("status"),
									rs.getInt("typeofrmbrsmt")
									);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null; // Optional Class -> can help avoid NullPointer Exceptions (if any one is curious)
		}
		
		
//		========================
		 public Reimbursement updateReimbursementStatus(int id, int employeeid, int status){
		        String sql = "update Reimbursement set status = ? where employeeid = ? and id = ? returning *;";

		        try(Connection connect = cu.getConnection()){
		            PreparedStatement ps = connect.prepareStatement(sql);
		            ps.setInt(1, status);
		            ps.setInt(2, employeeid);
		            ps.setInt(3, id);

		            ResultSet rs = ps.executeQuery();

		            if(rs.next()){
		                return new Reimbursement( 
		                		rs.getInt ("id"),
					            rs.getInt("employeeid"),
								rs.getString("daterequested"),
								rs.getInt("amount"),
								rs.getString("description"),
								rs.getInt("status"),
								rs.getInt("typeofrmbrsmt")
								);
		               
		            }
		        } catch(SQLException e){
		            e.printStackTrace();
		        }
		        return null;
		    }

//			========================
			 public Reimbursement updateReimbursementType(int id, int employeeid, int typeofrmbrsmnt){
			        String sql = "update Reimbursement set typeofrmbrsmnt = ? where employeeid = ? and id = ? returning *;";

			        try(Connection connect = cu.getConnection()){
			            PreparedStatement ps = connect.prepareStatement(sql);
			            ps.setInt(1, typeofrmbrsmnt);
			            ps.setInt(2, employeeid);
			            ps.setInt(3, id);

			            ResultSet rs = ps.executeQuery();

			            if(rs.next()){
			                return new Reimbursement( 
			                		rs.getInt ("id"),
						            rs.getInt("employeeid"),
									rs.getString("daterequested"),
									rs.getInt("amount"),
									rs.getString("description"),
									rs.getInt("status"),
									rs.getInt("typeofrmbrsmt")
									);
			               
			            }
			        } catch(SQLException e){
			            e.printStackTrace();
			        }
			        return null;
			    }
	
	
}
