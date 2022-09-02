# Project
This microservice is for the creation of hospital-application

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
Method 95 %
Line 89 %
```
# Run Application
Before running the application, check that port 8080(default port used by tomcat server) is free. If not, then change the port in application.properties file such as:
```
server.port=8081
```

```
mvn spring-boot:run
```
# Testing Application by Postman

Save Employee
```
curl --location --request POST 'localhost:8081/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "hospital_name": "WH!",
    "hospital_id": "h2",
    "address": "RingRoad1",
    "patients": [
        {
            "patient_name": "Darsh",
            "patient_id": "p1",
            "disease": "Asthma",
            "hospital_name": "h3"
        }
    ]
}'
```
Get Employee
```
curl --location --request GET 'localhost:8081/hospital/get?hospital_id=h2'
```
Update Employee
```
curl --location --request PUT 'localhost:8081/hospital/update?hospital_id=h2&address=Ringroad2'
```
Delete Employee
```
curl --location --request DELETE 'localhost:8081/hospital/delete?hospital_id=h2'
```
