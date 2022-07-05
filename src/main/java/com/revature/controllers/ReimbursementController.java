package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursement;

import com.revature.services.ReimbursementService;

import io.javalin.http.Context;


public class ReimbursementController {

	
private  ReimbursementService rs;
	
	public ReimbursementController(ReimbursementService rs) {
		this.rs = rs;
	}
	

	//==============
	// select all Reimbursement
	public void selectAllReimbursement(Context ctx) {
		ctx.status(200);
	    List<Reimbursement> reimbursements = rs.selectAllReimbursement();
		ctx.json(reimbursements);
}
	//==============
	public void createNewReimbursement(Context ctx) {
		ctx.status(201);
		Reimbursement reimbursementFromRequestBody = ctx.bodyAsClass(Reimbursement.class);
		Reimbursement u = rs.createNewReimbursement(reimbursementFromRequestBody); // unmarshalling
		ctx.json(u);
	}
	//==============
	public void getReimbursementById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Reimbursement u = null;
		try {
			u = rs.getReimbursementById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			ctx.status(404);
		}
		
	}
//	//==============
//	public void deleteEmployee(Context ctx) {
//		int id = Integer.parseInt(ctx.pathParam("id"));
//		es.deleteEmployee(id);
//	}
	
//	==============
	public void updateReimbursementStatus(Context ctx) {
	
	int id = Integer.parseInt(ctx.pathParam("id"));
	int employeeid = Integer.parseInt(ctx.pathParam("employeeid"));
	Reimbursement r = ctx.bodyAsClass(Reimbursement.class); //unmarshalling
	int status = r.getStatus();
	
	Reimbursement uChanged = rs.updateReimbursementStatus(id, employeeid, status);
	
	if (uChanged != null) {
		ctx.status(200);
		ctx.json(uChanged);
	} else { ctx.status (404);}
	}
//	//==============
////	==============
	public void updateReimbursementType(Context ctx) {
	
	int id = Integer.parseInt(ctx.pathParam("id"));
	int employeeid = Integer.parseInt(ctx.pathParam("employeeid"));
	Reimbursement r = ctx.bodyAsClass(Reimbursement.class); //unmarshalling
	int typeofrmbrsmnt = r.getStatus();
	
	Reimbursement uChanged = rs.updateReimbursementType(id, employeeid, typeofrmbrsmnt);
	
	if (uChanged != null) {
		ctx.status(200);
		ctx.json(uChanged);
	} else { ctx.status (404);}
	}
	
	
}
