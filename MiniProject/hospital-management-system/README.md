# Project By Darsh Jotangia
This microservice i.e. hospital-management-system is for the creation of doctorcontroller, patientcontroller and prescriptioncontroller

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
and add appropriate properties for mongodb
```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=test_db
```

Build docker image

```
mvn install dockerfile:build
```

For Files with name other than docker-compose.yml

```
docker-compose -f docker-compose.yml up -d
```

Or for docker-compose.yml

```
docker-compose up
```
To run the application( but here it won't be required as application will start as docker container )
```
mvn spring-boot:run
```

# Users
```
DOCTOR - doctor1	PASSWORD - password
```
```
PATIENT - patient1	PASSWORD - password
```
```
DOCTOR,PATIENT - user1	PASSWORD - password
```

# Swagger
```
http://localhost:8081/swagger-ui/index.html
```

# Testing Application in IntelliJ
Test Cases were made for each mapping and with code coverage
```
Class 100 %
Method 93 %
Line 88 %
```

# Testing Application by Postman

Save Prescription

```
curl --location --request POST 'localhost:8081/saveprescription' \
--header 'Authorization: Basic dXNlcjE6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "prescriptionId":"pres2",
    "appointmentId":"appoint2",
    "description":"presc test",
    "patientName":"patient2",
    "doctorName":"doctor1"
}'
```

Get Prescription

```
curl --location --request GET 'localhost:8081/viewprescription?patientName=patient2' \
--header 'Authorization: Basic dXNlcjE6cGFzc3dvcmQ=' \
--data-raw ''
```

Save Appointment From Doctor Controller

```
curl --location --request POST 'localhost:8081/doctor/save' \
--header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=724F92BE6E7D9B6C4624E58CAAC2DCFD' \
--data-raw '{
    "appointmentId":"appointap2",
    "patientName":"patient2",
    "doctorName":"doctor1",
    "date":"05/09/2022",
    "prescription":{
     "prescriptionId":"presap2",
     "appointmentId":"appointap2",
     "description":"presc test",
     "patientName":"patient2",
     "doctorName":"doctor1"
    }
}'
```
Get Appointment from Doctor Controller

```
curl --location --request GET 'localhost:8081/doctor/doctorappointment?doctorName=doctor1' \
--header 'Authorization: Basic ZG9jdG9yMTpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=724F92BE6E7D9B6C4624E58CAAC2DCFD' \
--data-raw ''
```

Save Appointment From Patient Controller

```
curl --location --request POST 'localhost:8081/patient/save' \
--header 'Authorization: Basic cGF0aWVudDE6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=724F92BE6E7D9B6C4624E58CAAC2DCFD' \
--data-raw '{
    "appointmentId":"appointap4",
    "patientName":"patient3",
    "doctorName":"doctor2",
    "date":"05/09/2022",
    "prescription":{
     "prescriptionId":"presap3",
     "appointmentId":"appointap4",
     "description":"presc test",
     "patientName":"patient3",
     "doctorName":"doctor2"
    }
}'
```

Get Appointment from Patient Controller

```
curl --location --request GET 'localhost:8081/patient/myappointment?patientName=patient3' \
--header 'Authorization: Basic cGF0aWVudDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=724F92BE6E7D9B6C4624E58CAAC2DCFD' \
--data-raw ''
```

# Show data:

```
docker exec -it hospotal-management-system_mongo_1 bash
mongo
show dbs
use database
show tables
db.appointment.find()
db.prescription.find()
```
# Stop the containers

For Files with name other than docker-compose.yml

```
docker-compose -f docker-compose.yml down
```

Or for docker-compose.yml

```
docker-compose down
```