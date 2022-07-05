package com.revature.services;


import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;

public class ReimbursementService {

	private static ReimbursementDAO reimbursementDao;
	public ReimbursementService(ReimbursementDAO reimbursementDao) {
		this.reimbursementDao = reimbursementDao;
	}
	
// register / create Reimbursement
		public Reimbursement createNewReimbursement(Reimbursement r) {
			Reimbursement createdReimbursement = reimbursementDao.createNewReimbursement(r);
			return createdReimbursement;
		}

// select all reimbursement
		public List<Reimbursement> selectAllReimbursement() {
			
		return reimbursementDao.selectAllReimbursement();
		}

		public Reimbursement getReimbursementById(int id) throws Exception {
			// this is where you could put some business logic 
			// for example checking if the User returned by userDao.getUserById(id) is null 
			Reimbursement r = reimbursementDao.getReimbursementById(id);
			if (r == null) {
				throw new Exception("Reimbursement not found");
			}
			return r;
		}
		
		// =========================
		
// update Reimbursement status
				public Reimbursement updateReimbursementStatus(int id, int employeeid, int status) {
					Reimbursement updatedReimbursement = reimbursementDao.updateReimbursementStatus(id, employeeid,  status);
					return updatedReimbursement;
				}
      // =========================
				
// update Reimbursement type
						public Reimbursement updateReimbursementType(int id, int employeeid, int typeofrmbrsmnt) {
							Reimbursement updatedReimbursementType = reimbursementDao.updateReimbursementType(id, employeeid,  typeofrmbrsmnt);
							return updatedReimbursementType;
						}

			
		
}
