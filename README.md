# sayOneAssignment

Assumptions
-------------------
We need to accept both country code and courseid for getting the course pricing details.

Data Store Setting
--------------------
Import the attached  sql file(Database.sql) into the mysql server.
Change the credentials of Data Base on application.yaml file with yours.

 Building and running the code
 --------------------
  Use command java -jar sayone-course-service-1.0.jar to run the application .
      
 Testing
 --------------------
 Use SwaggerUI for test the application.
 It will be avialable on 'http://localhost:8080/swagger-ui.html' after successfully running the application.
 
 
 Test Data
-------------------

http://localhost:8080/sayone/service/courses/getCourseList?countryCode=US&courseId=1

  
  
