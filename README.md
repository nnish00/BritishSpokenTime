# BritishSpokenTime Spring Boot Application

## Introduction
This is a simple Spring Boot application that converts time in the format "HH:mm" to spoken British English.

## Prerequisites
- Java 17
- Apache Maven

## Getting Started
1. Clone this repository to your local machine.
2. Ensure you have Java 17 installed. You can check your Java version by running `java -version` in your terminal.
3. Ensure you have Apache Maven installed. You can check your Maven version by running `mvn -version` in your terminal.
4. Navigate to the root directory of the project in your terminal.
5. Build the project using Maven by running `mvn clean package`.
6. Once the build is successful, you can run the application using the following command:
   java -jar target/BritishSpokenTime-1.0-SNAPSHOT.jar
7. The application will start, and you can access it at `http://localhost:8080`.

## Usage
- The application exposes a single endpoint for converting time to spoken British English.
- Send a GET request to `http://localhost:8080/convertTime?time=HH:mm`, replacing `HH:mm` with the time you want to convert.
- For example, to convert the time "15:45", you would send a GET request to `http://localhost:8080/convertTime?time=15:45`.

## Directory Structure
- `src/main/java/com/sb`: Contains the Java source code.
- `BritishSpokenTimeApplication.java`: Main class to start the Spring Boot application.
- `controller/TimeController.java`: Controller class defining REST endpoints.
- `service/TimeService.java`: Service class responsible for converting time to words.
- `constants/AppConstants.java`: Constants used throughout the application.
- `src/test/java/com/sb`: Contains unit tests for the application.
- `pom.xml`: Maven project configuration file.

## Dependencies
- Spring Boot Web Starter: For creating RESTful web services.
- Spring Boot Starter Test: For testing Spring Boot applications.
- Spring Boot Starter Validation: For validation support.
- Mockito Core: For mocking objects in unit tests.
- JUnit: For unit testing.

## Build and Run Tests
- Build the project: `mvn clean package`
- Run tests: `mvn test`

## Authors
- Nishant Kumar Singh

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

