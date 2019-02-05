# java-angular-reimbursement
Reimbursement webapp using Java, Hibernate, JDBC, PostgreSQL, Angular, Typescript, JavaScript, Bootstrap

### Functionality Description
Log in as manager or employee. Manager sees all requests and can filter by status and sort by column. 
Manager can review details of reimbursement requests and Approve/Deny requests.
Employee sees only their submitted requests and can filter by status and sort by column. 
Employee can submit a new expense form and see updated form status when resolved by a manager.

### Screenshots

#### Login view
![login view](https://raw.githubusercontent.com/emily-v/java-angular-reimbursement/master/screenshots/login.png)

#### Manager Home
![manager home](https://raw.githubusercontent.com/emily-v/java-angular-reimbursement/master/screenshots/mgr-home.png)

#### Manager Approve/Deny
![manager approve or deny](https://raw.githubusercontent.com/emily-v/java-angular-reimbursement/master/screenshots/mgr-resolve.png)

#### Employee Home
![employee home](https://raw.githubusercontent.com/emily-v/java-angular-reimbursement/master/screenshots/emp-home.png)

#### New Expense Form
![new expense form](https://raw.githubusercontent.com/emily-v/java-angular-reimbursement/master/screenshots/new-exp.png)


### To run application:
* Edit database url and credentials in src/main/resources/hibernate.cfg.xml
* Start up Apache Tomcat
* $ mvn clean package && mvn tomcat7:deploy from root folder
* Serve angular application $ ng serve
* Must enable CORS


