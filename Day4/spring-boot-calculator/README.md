# Project
This Application is to understand the various annotations with spring boot application for a calculator.

##
Create Project

```bash
$mvn archetype:generate -DgroupId=com.darsh.app -DartifactId=spring-boot-calculator -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```bash
$ mvn clean install
```

## Dockerization

### Maven

## Build docker images

```bash
$ mvn install dockerfile:build
```


## Running

The application can be start is either locally using maven or start in docker container.

### Running the application in local environment
Using eclipse:It can be run as java application or run configuration to provide the program arguments.
You can run using maven command as:

```bash
$ mvn spring-boot:run
```

### Running the application in docker container

```bash
$ docker run -p 8081:8081 darsh010/spring-boot-calculator:0.0.1-SNAPSHOT 

```



## Testing

1)http://localhost:8081/add
2)http://localhost:8081/sub
3)http://localhost:8081/mul
4)http://localhost:8081/div


