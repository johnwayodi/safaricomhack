### CareerRegistration
a spring boot project that mimics a job application portal.

#### Configuration and Deployment

##### Application
clone the Repository:

`git clone https://github.com/johnwayodi/safaricomhack.git`  

Next install dependencies:
`mvn package`

Run the Project:
`mvn spring-boot:run`

Access the project on your browser using url `localhost:8080/`

##### H2 Database
Ensure that the spring project is up and running.

The H2 database can be accessed on url `localhost:8080/console`

In the login page, change the **JDBC URL** to `jdbc:h2:file:./data/testdb` as that is the url configured in the **application.properties**

After that press the **connect** to access the dashboard.