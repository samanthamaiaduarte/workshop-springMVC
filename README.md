
# Payment control app

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-6DB33F?style=flat&logo=spring&logoColor=white) 
![Thymeleaf](https://img.shields.io/badge/thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/-boostrap-7952B3?style=flat&logo=bootstrap&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)
![H2 DB](https://img.shields.io/badge/H2Database-4479A1?style=flat&logo=openjdk&logoColor=white)
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](./LICENSE)

### Challenge
The aim of this hands-on practical project is to use Spring MVC Framework to create a functional app to control payments.

Created during Algaworks Spring MVC Workshop

#### Proposal
To create a complete functional payments control, which can be accessed by browser and has all four operations (create, read, update and delete) plus set "payed" status.

## Installation

1. Clone the repository:
```bash
git clone https://github.com/samanthamaiaduarte/workshop-springMVC.git
```
2. Access ```workshop-springMVC``` directory:
```bash
cd workshop-springMVC
```
3. Download dependencies with maven:
```bash
./mvnw.cmd -DskipTests install
```
4. Build maven package:
```bash
./mvnw.cmd -DskipTests clean package
```
### To run application in H2 Database

Run the application:
```bash
java -DskipTests -Dspring.profiles.active=h2db -jar target/workshop-springMVC-0.0.1-SNAPSHOT.jar
```

### To run application in MySQL Database

1. Create a empty database in MySQL

2. Run the application replacing:<br/>
a. {SERVER_NAME} for your server name or ip address <br/>
b. {PORT} for your server port <br/>
c. {DATABASE_NAME} for the database name you just created<br/>
d. {USERNAME} for the database access username<br/>
e. {PASSWORD} for the database access password

```bash
java -DskipTests -Dspring.profiles.active=mysql -DURL_DB=jdbc:mysql://{SERVER_NAME}:{PORT}/{DATABASE_NAME} -DUSER_DB={USERNAME} -DPASS_DB={PASSWORD} -jar target/workshop-springMVC-0.0.1-SNAPSHOT.jar
```

## Usage

To access, open your browser and go to:
```
http://localhost:8080/titulos
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.
