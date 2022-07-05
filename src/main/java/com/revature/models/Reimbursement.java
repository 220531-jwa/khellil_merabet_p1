package com.revature.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Reimbursement {
	private int id;
	private int employeeId;
	private String dateRequested;
	private int amount;
	private String description;
   // private ReimbursementStatus status;
    private int status;
	//private ReimbursementType typeOfRmbrsmt;
   private int typeOfRmbrsmt;
   
	public Reimbursement() {}

	public Reimbursement(int id, int employeeId, String dateRequested, int amount, String description,
			int status, int typeOfRmbrsmt) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.dateRequested = dateRequested;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.typeOfRmbrsmt = typeOfRmbrsmt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTypeOfRmbrsmt() {
		return typeOfRmbrsmt;
	}

	public void setTypeOfRmbrsmt(int typeOfRmbrsmt) {
		this.typeOfRmbrsmt = typeOfRmbrsmt;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employeeId=" + employeeId + ", dateRequested=" + dateRequested
				+ ", amount=" + amount + ", description=" + description + ", status=" + status + ", typeOfRmbrsmt="
				+ typeOfRmbrsmt + "]";
	}
	
	
}
