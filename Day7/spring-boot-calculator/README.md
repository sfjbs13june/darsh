# Project
This Application is to understand the various annotations with spring boot application for a calculator.

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
Method 90 %
Line 92 %
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

1)Addition
```
curl --location --request GET 'localhost:8081/add?a=3.0&b=4.0'
```
2)Subtraction
```
curl --location --request GET 'localhost:8081/sub?a=8.0&b=4.0'
```
3)Multiplication
```
curl --location --request GET 'localhost:8081/mul?a=8.0&b=4.0'
```
4)Division
```
curl --location --request GET 'localhost:8081/div?a=8.0&b=4.0'
```

5)Add String
```
curl --location --request GET 'localhost:8081/addstring?a=hello&b=darsh'
```

