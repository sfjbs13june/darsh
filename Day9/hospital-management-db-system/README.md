# Project
This microservice is for the creation of hospitalcontroller and patientcontroller

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
docker-compose -f docker-compose-mysql.yml up -d

mvn spring-boot:run

docker-compose -f docker-compose-mysql.yml down
```
# Testing Application by Postman

Save Patient
```
curl --location --request POST 'localhost:8081/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Darsh",
    "disease":"Asthma",
    "hospitalName":"WH"
}'
```

Get Patient
```
curl --location --request GET 'localhost:8081/patient/get?id=4'
```

Update Patient
```
curl --location --request PUT 'localhost:8081/patient/update?id=4&disease=Cancer'
```

Delete Patient
```
curl --location --request DELETE 'localhost:8081/patient/delete?id=4'
```

Save Hospital
```
curl --location --request POST 'localhost:8081/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"WH",
"address":"RingRoad",
"patientName":"Darsh"
}'
```

Get Hospital
```
curl --location --request GET 'localhost:8081/hospital/get?id=7'
```

Update Hospital
```
curl --location --request PUT 'localhost:8081/hospital/update?id=7&patientName=DBJ'
```

Delete Hospital
```
curl --location --request DELETE 'localhost:8081/hospital/delete?id=6'
```