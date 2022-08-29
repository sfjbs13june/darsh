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

# Authorization

This application has 4 users:
darsh       -   ADMIN
user123     -   USER
admin123    -   ADMIN
test123     -   USER

# Testing Application

Save Employee

```
curl --location --request POST 'localhost:8081/save/employee' \
--header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=EE2D581A21A9A930F6BA8F002B6B6305' \
--data-raw '{
    "empId":"1234567",
    "empName":"Darsh",
    "salary":"600000",
    "dept":"AWS"
}'
```

Get Employee

```
curl --location --request GET 'localhost:8081/get/employee?name=Darsh' \
--header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=EE2D581A21A9A930F6BA8F002B6B6305'
```
Update Employee

```
curl --location --request PUT 'localhost:8081/update/employee?salary=80000&name=Darsh' \
--header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=EE2D581A21A9A930F6BA8F002B6B6305'
```

Delete Employee

```
curl --location --request DELETE 'localhost:8081/delete/employee?name=Darsh' \
--header 'Authorization: Basic ZGFyc2g6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=EE2D581A21A9A930F6BA8F002B6B6305'
```
