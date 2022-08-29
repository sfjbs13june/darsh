# Create Application
```
https://start.spring.io/
```
# Build Project
```
mvn clean install
```
# Run Application
Before running the application, check that port 8080(default port used by tomcat server) is free. If not, then change the port in application.properties file such as:
```
server.port=8081
```

```
mvn spring-boot:run
```
# Testing Application

Save Employee
```
curl --location --request POST 'localhost:8081/save/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
"empId":"1234567",
"empName":"Darsh",
"salary":"600000",
"dept":"AWS"
}'
```
Get Employee
```
curl --location --request GET 'localhost:8081/get/employee?name=Darsh'
```
Update Employee
```
curl --location --request PUT 'localhost:8081/update/employee?salary=80000&name=Darsh'
```
Delete Employee
```
curl --location --request DELETE 'localhost:8081/delete/employee?name=Darsh'
```
