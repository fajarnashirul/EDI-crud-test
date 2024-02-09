# EDI-crud-test
project for technical test EDI

## Built With
- Java 17
- Maven
- Spring Web
- Spring Data JPA
- MySQL Driver
- MyBatis
- Lombok

## Installation

Setting database in application.properties

Use the package manager [mvn](https://maven.apache.org/) to install the library and create .jar file.
```bash
mvn install
```

## Usage
Start application
```bash
java -jar [your path to .jar file]/file.jar
```
## Feature
- getDataUser: [Get] localhost:8080/user/:userId
- setDataUser: [Post] localhost:8080/user/create
- DelDataUser: [Delete] localhost:8080/user/:userId
