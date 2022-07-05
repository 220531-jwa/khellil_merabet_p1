import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.ReimbursementController;
import com.revature.models.Reimbursement;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class JavalinERS {

	public static void main(String[] args) {
		EmployeeController uc = new EmployeeController(new EmployeeService(new EmployeeDAO()));
		
		ReimbursementController rc = new ReimbursementController(new ReimbursementService(new ReimbursementDAO()));
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
	//	config.enableCorsForOrigin("http://localhost:8080");
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		app.start(8080);
		
		// Javalin provides us with a Context Class (ctx) that represents information 
		// about BOTH the Http Request AND Http Response Objects
		// we'll be using methods from the context class to handle our incoming http requests
		// and to send our http resonses
		
		// lambdas - introduced functional programming to Java
		// (parameter) -> {// implementation}
		
		app.routes(() -> {
			    path("/login", () -> {
				  post(uc::loginEmployee);
			});
			  path("/employees", () -> { // http://localhost:8080/users
	            get(uc::getAllEmployee);
				post(uc::createNewEmployee);
				path("/{employeeid}", () -> { // http://localhost:8080/users/10
					get(uc::getEmployeeById);
					delete(uc::deleteEmployee);
					put(uc::updateEmployee); 
					patch(uc::updatePassword);
					post(uc::createNewEmployee);
					path("/reimbursements", () -> { //http://localhost:8080/users/10/books
						  get(rc::selectAllReimbursement);
						  post(rc::createNewReimbursement);
						  path("/{id}", () -> { // http://localhost:8080/users/10
							get(rc::getReimbursementById);
							//delete(rc::delete...)
					      });
					    });
					
					
//					path("/reimbursements", () -> { //http://localhost:8080/users/10/books
//						get(rc::selectAllReimbursement); 
//						get(ctx -> {
//							int id = Integer.parseInt(ctx.pathParam("id"));
//       						   List<Reimbursement> reimbursements = bd.selectAllReimbursement(id);
//							ctx.status(200);
//							ctx.json(reimbursements);
//						});
//						path("/{bookId}", () -> { //http://localhost:8080/users/10/books/5?someQueryParamKey=someValue?anotherQParam=helloagain
//							patch(BookController::markBookAsRead);
//						});
						
					});
				});
			});
			// Exception Mapping - best practice would be to use a more specific (or even custom) exception like a UserNotFoundException
//		app.exception(Exception.class, (e, ctx) -> {
//		    ctx.status(404);
//		    ctx.result("<h1>User not found</h1>");
//		});
		// Error Mapping
		//app.error(404, ctx -> { ctx.result("Hahahah you typed in the url wrong");});
		
		// Test Endpoints that won't be in the final application 
		app.get("/test", ctx -> {
			ctx.status(200);
			String name = ctx.queryParam("name");
			ctx.result("Test successful! Hello " + name);
		});
		
		app.get("/bodystring",ctx -> {
			
			String body = ctx.body();
			System.out.println("Body: " + body);
			String[] split = body.split(":");
			 
			 for (String s : split) {
				 System.out.println(s);
			 }
			
		});
		
	}

}
