# CareerRegistration
A spring-boot project that mimics a job application portal.

### Configuration and Deployment

#### Application
1. Clone the Repository:
`git clone https://github.com/johnwayodi/safaricomhack.git`  

2. Next install dependencies:
`mvn package`

3. Run the Project:
`mvn spring-boot:run`

4. Access the project on your browser using url `localhost:8080/`

#### H2 Database
1. Ensure that the spring project is up and running.

2. The H2 database can be accessed on url `localhost:8080/console`

3. In the login page, change the **JDBC URL** to `jdbc:h2:file:./data/testdb` as that is the url configured in the **application.properties**

4. Press **connect** to access the H2 Dashboard.

## API Usage
The application also exposes Restful endpoints from which CRUD operations can be performed. The API endpoints are:
* `localhost:8080/jobs/`
* `localhost:8080/jobapplicants/`

**[Postman](https://www.getpostman.com/)** is used as it allows easy testing of apis. 
#### 1. Adding a Job Example
1. Ensure the spring application is running
2. Open Postman, change the method to **POST** and set the url field to `localhost:8080/jobs/`
3. In the **Header** section, set Content-Type to *application/json*
4. Input the Job Details you wish to add to database in the **Body** section after selecting the *raw* property

Example Job Structure:
    
    {
    	"name":"android developer",
    	"description":"design and develop android apps",
    	"jobType":"animation engineer",
    	"yearsOfExperience":5,
    	"educationLevel":"bachelors",
    	"status":true,
    	"interviewDate":"2018-09-01",
    	"interviewStartTime":"2018-09-01 09:00:59",
    	"interviewStopTime": "2018-09-01 12:00:59"
    }

#### 2. Adding a JobApplicant Example
1. Ensure the spring application is running
2. Open Postman, change the method to **POST** and set the url field to `localhost:8080/jobapplicants/`
3. In the **Header** section, set Content-Type to *application/json*
4. Input the Applicants Details you wish to add to database in the **Body** section after selecting the *raw* property

Example JobApplicant Structure:
    
    {
    	"firstName" : "Arnold",
    	"lastName" : "Schwatz",
    	"email" : "ashwatz@gmail.com",
    	"password":"test",
    	"phone":"070000000",
    	"educationLevel":"Bachelors",
    	"yearsOfExperience": 2
    }
    
## Testing
**NOTE**: The database is already created in folder **data** and will be loaded automatically.

After Logging in you will be requested to enter the Job Type to search

Job Types already in Database include: 
* api engineer
* ux engineer
* data engineer
* systems engineer

