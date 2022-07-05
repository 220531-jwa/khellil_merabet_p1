package com.revature.models;

public class ReimbursementType {
	private int id;
	private String typeOfRmbrsmnt;
	
	public ReimbursementType () {
	}

	public ReimbursementType(int id, String typeOfRmbrsmnt) {
		super();
		this.id = id;
		this.typeOfRmbrsmnt = typeOfRmbrsmnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeOfRmbrsmnt() {
		return typeOfRmbrsmnt;
	}

	public void setTypeOfRmbrsmnt(String typeOfRmbrsmnt) {
		this.typeOfRmbrsmnt = typeOfRmbrsmnt;
	}

	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", typeOfRmbrsmnt=" + typeOfRmbrsmnt + "]";
	}
	
	
}
