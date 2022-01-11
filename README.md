# TexasHamburger
A spring boot app to provide api end points and handle data streaming for faked Hamburger store chain


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Tools used for this project:

IntelliJ Idea / Other Suitabe Ide
JDK 11 (used for this project)
Docker
Docker-compose
Kafka and zookeeper (inside docker container)

Dependencies are below:

pom.xml
```
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

<!--		Logging tools dependencies-->
		<!-- Exclude Spring Boot's Default Logging -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- Add Log4j2 Dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
<!--		<dependency>-->
<!--			<groupId>org.springframework.boot</groupId>-->
<!--			<artifactId>spring-boot-starter-oauth2-client</artifactId>-->
<!--			<version>2.3.3.RELEASE</version>-->
<!--		</dependency>-->

<!--		Databases dependencies-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.27</version>
			<scope>runtime</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>2.6.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka-dist -->
		<dependency>
			<groupId>org.springframework.kafka</groupId>
			<artifactId>spring-kafka</artifactId>
		</dependency>

		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.assertj/assertj-core -->
		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.22.0</version>
			<scope>test</scope>
		</dependency>
    
```

### Kafka Setting (Make sure to do this before running the main application)
Although most of the setting has been handled in the code or docker compose files, there are few setups that need to be done before being able to use Kafka data streaming. The steps are as follows:
- Open terminal and navigate to the project directory.
- Run the following command:
```
docker exec -it broker bash
```
- This will get you the kafka container's bash in interactive mode. Then hit the following series of commands:
```
kafka-topics --bootstrap-server broker:9092 --create --topic orders
kafka-console-consumer --bootstrap-server broker:9092 --topic orders --from-beginning
```
- Now you're listening for the messages in kafka topic named "orders" where our spring boot application will push daily orders data through path "/api/order/all".
`

### Installing

Steps to build from source:
- Clone the project using
```
https://github.com/sushantcode/TexasHamburger.git 
```
to your local machine.
- Open terminal and cd into TexasHamburger/THCSpringBootAPI directory.
- If you have git bash, Run command:
```
./run.sh
```
Or, run commands:
```
./mvnw clean install
docker-compose up --build
```
- Once the images are build, up and running, navigate to your broswer and hit the following url:
```
http://localhost:8080/swagger-ui.html
```
- This page will show all api endpoints and data models with sufficient description


## Authors

* **Gupta, Sushant** - *Core Team Member* - [Profile](https://github.com/sushantcode)

