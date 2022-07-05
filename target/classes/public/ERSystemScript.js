let baseUrl = "http://localhost:8080"; // /users, /users/1

async function login() {
    console.log("login button pressed")

    // gather input from the user - using our DOM
    let uname = document.getElementById('uname').value;

    let pass = document.getElementById('pass').value;

    // create an object literal 
    let user = {
        username: uname,
        password: pass
    }

    // print that to the console
    console.log(user);

       // we need to convert the user object literal to a Json string
    // so we can send it in the body of our request
    let userJson = JSON.stringify(user);
    console.log(userJson);
    // send a POST request to our backend using the Fetch API
    // fetch method returns a Promise
    let res = await fetch(
                        `${baseUrl}/login`, // the url where we're sending this request
                        {
                            method: 'POST',
                            header: {'Content-Type': 'application/json'},
                            body: userJson
                        }
                    );
    let resJson = await res.json()
        // .then will execute if the promise is successfully resolved
        // .then() takes a function as an argument
        .then((resp) => {
            console.log(resp); // this is where we will eventually put our DOM manipulation if needed
            window.location.assign("homePage.html");
        })
        // .catch will execute if there's any error
        .catch((error) => {
            console.log(error= "Employee/Manager not found");
        });
    
}


// ================================

async function submitReimbursement() {
    
    let requestId = document.getElementById('idname').value;

      let emlpoyeeIdd = document.getElementById('idEmployee').value;
      let date = document.getElementById('idDate').value;
      let amount = document.getElementById('idAmount').value;
      let descriptio = document.getElementById('reviewText').value;
      let statuss = document.getElementById('idStatus').value;
      let typeofR = document.getElementById('idTypeofR').value;

    let Req_Reimbursement = {
  // those in the left hand should be exactly the same as diclared in your class Reimbursement.java
        id: requestId,
        employeeId: emlpoyeeIdd,
        dateRequested: date,
        amount: amount,
        description : descriptio,
        status : statuss,
        typeOfRmbrsmt : typeofR
    }

    console.log(Req_Reimbursement);

    let ReimbursementJson = JSON.stringify(Req_Reimbursement);
    console.log(ReimbursementJson);

    let res = await fetch(
        `${baseUrl}/employees/id/reimbursements`,
        {
            method : 'POST',
            header : {'Content-Type': 'application/json'},
            body: ReimbursementJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location.assign("requestReimbursement.html");
           // console.log(resp = "Hello employye, your request got send");
        })
        .catch((error) => {
            console.log(error = "Reimbursement not send");
            
        });
}

//  ========= Add new Employee
async function AddNewEmployee() {
    
      let EmployeeId = document.getElementById('idEmploy').value;
      let FistName = document.getElementById('idFirstname').value;
      let LastName = document.getElementById('idLastname').value;
      let Username = document.getElementById('idUsername').value;
      let Password = document.getElementById('idPassword').value;
      let Email = document.getElementById('idEmail').value;
      let Role = document.getElementById('idRole').value;
      
    let NewEmployee = {
  // those in the left hand should be exactly the same as diclared in your class Employee.java
        employeeId: EmployeeId,
        firstName: FistName,
        lastName: LastName,
        username : Username,
        password : Password,
        email : Email,
        employeeRole : Role
    }


    console.log(NewEmployee);

    let NewEmployeeJson = JSON.stringify(NewEmployee);
    console.log(NewEmployeeJson);

    let res = await fetch(
        `${baseUrl}/employees`,
        {
            method : 'POST',
            header : {'Content-Type': 'application/json'},
            body: NewEmployeeJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location.assign("AddNewEmployee.html");
            //window.location.assign(resp = "Hello Manager, you just created a new employee");
            console.log(resp = "Hello Manager, you just created a new employee");
        })
        .catch((error) => {
            console.log(error = "New Employee not created");
            
        });
}





//  =====================

function submitReview() {
    let reviewText = document.getElementById('reviewText').value;
    let selection = document.getElementById('select').value;

    let reimbursementReview = {
        text: reviewText,
        rating: selection
    }
    console.log(reimbursementReview);
}




