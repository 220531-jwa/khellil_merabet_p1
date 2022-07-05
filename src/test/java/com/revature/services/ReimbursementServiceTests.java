package com.revature.services;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.ArgumentMatchers.anyString;
	import static org.mockito.Mockito.when;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;

	@ExtendWith(MockitoExtension.class)
	
public class ReimbursementServiceTests {

		@InjectMocks
		ReimbursementService reimbursementServiceMocks;
         // private static ReimbursementService reimbursementServiceMoks;
		
		@Mock
		ReimbursementDAO reimbursementDaoMock;
		//private static ReimbursementDAO reimbursementDaoMock;
		
//		@BeforeEach
//		public void setupEach() {
//			reimbursementServiceMocks = new ReimbursementService(reimbursementDaoMock);
//		}
		
		@Test
		public void SendRequestWithValidInput() {
    // Given
			Reimbursement mockReimbursement = new Reimbursement(1, 1, "2022/03/07", 1, "description", 1, 1);
			//Reimbursement mockReimbursement = new Reimbursement();
	// When
			when(reimbursementDaoMock.createNewReimbursement(1, 1, "2022/03/07", 1, "description", 1, 1))
				.thenReturn(mockReimbursement);
    // Then
			Reimbursement loggedInEmployee = reimbursementServiceMocks.createNewReimbursement(1, 1, "2022/03/07", 1, "description", 1, 1);

			assertEquals(mockReimbursement, loggedInEmployee);


		}	
		
		
		
}
