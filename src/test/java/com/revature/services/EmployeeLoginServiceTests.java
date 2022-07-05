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

	import com.revature.models.Employee;
	import com.revature.repositories.EmployeeDAO;

	@ExtendWith(MockitoExtension.class)
	
	public class EmployeeLoginServiceTests {


		@InjectMocks
		EmployeeService employeeService;

		@Mock
		EmployeeDAO userDaoMock;


		@BeforeEach
		public void setupEach() {
			employeeService = new EmployeeService(userDaoMock);
		}


		@Test
		public void loginWithValidInput() {

			Employee mockUser = new Employee(1,"firstname", "lastname", "username", "pass", "email", "emlpoyeeRole");

			when(userDaoMock.getUserByUsername(anyString()))
				.thenReturn(mockUser);

			Employee loggedInUser = employeeService.login("username", "pass");

			assertEquals(mockUser, loggedInUser);


		}



		@Test
		public void loginWithInvalidUsernameShouldReturnNull() {
			Employee mockUser = new Employee(1, "firstname", "lastname", "username", "pass", "email", "emlpoyeeRole");
			when(userDaoMock.getUserByUsername(anyString()))
			.thenReturn(mockUser);

			Employee loggedInUser = employeeService.login("user$$name", "password");

			assertEquals(null, loggedInUser);
		}


		@Test
		public void loginWithInvalidPasswordShouldReturnNull() {

			Employee mockUser = new Employee(1, "firstname", "lastname", "username", "pass", "email", "emlpoyeeRole");

			when(userDaoMock.getUserByUsername(anyString()))
			.thenReturn(mockUser);

			Employee loggedInUser = employeeService.login("username", "pa$$word");

			assertEquals(null, loggedInUser);
		}

		
}
