# Project
This microservice is for the creation of patient-application

# Create Application
```
https://start.spring.io/
```
# Build Project
```
mvn clean install
```
# Testing Application in IntelliJ
Test Cases were made for each mapping and with code coverage
```
Class 100 %
Method 93 %
Line 86 %
```
# Run Application
Before running the application, check that port 8080(default port used by tomcat server) is free. If not, then change the port in application.properties file such as:
```
server.port=8082
```

```
mvn spring-boot:run
```
# Testing Application by Postman

Save Employee
```
curl --location --request POST 'localhost:8082/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "patient_name": "Darsh",
    "patient_id": "p1",
    "disease": "Asthma",
    "hospital_name":"WH"
}'
```
Get Employee
```
curl --location --request GET 'localhost:8082/patient/get?patient_id=p1'
```
Update Employee
```
curl --location --request PUT 'localhost:8082/patient/update?patient_id=p1&disease=Cancer'
```
Delete Employee
```
curl --location --request DELETE 'localhost:8082/patient/delete?patient_id=p1'
```
