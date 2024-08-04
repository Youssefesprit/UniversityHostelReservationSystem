# 🏨 University Hostel Reservation System

## 📌 Project Overview
The University Hostel Reservation System is a web-based application designed to simplify the room reservation process for students at university hostels. It efficiently manages the bidirectional relationships between universities, hostels, students, and their reservations using the Spring Framework.

## 📊 Class Diagram
![Class Diagram](https://github.com/user-attachments/assets/916293b5-9e1a-4110-bb31-05a09a558f3a)

## 🌟 Features
- **📅 Room Booking**: Enables students to easily reserve rooms.
- **🖥️ Management Dashboard**: Provides administrative functionalities to manage hostels, reservations, and student details.
- **🔄 Automated Room Allocation**: Optimizes room allocation based on student preferences and availability.

## 🔧 Technologies Used
- **🍃 Spring Framework**: For robust back-end functionality.
- **📊 Spring Data JPA**: Manages relational data in a Java application.
- **🔧 Lombok**: Simplifies code by automatically generating getters, setters, and other common methods.
- **⚙️ Spring AOP**: Enhances modularity with aspect-oriented programming including logging and transactions.
- **📘 OpenAPI**: Facilitates API development and testing with documented endpoints.
- **🚀 Spring Boot**: Utilized for its powerful dependency management and auto-configuration capabilities.
- **🔗 Spring MVC**: Employed for handling web requests with RESTful controllers.
- **⏲️ Spring Scheduler**: Enables the execution of scheduled tasks.
- **🔍 Spring Data JPA**: Used for repository management and JPQL for database interaction.
- **🌐 Dependency Injection**: Demonstrates the injection of dependencies within the Spring context.
- **📝 API Documentation**: Documented with Spring MVC and Swagger for clear API communication.
## 🛠 Installation

### Prerequisites
Before running the application, you will need to set up the required database. Follow these steps to create your database:

1. **Create the Database**:
   Ensure that you have MySQL installed on your system. Open your MySQL command line or a GUI tool like MySQL Workbench and execute the following SQL command:

   ```sql
   CREATE DATABASE universityHousingDB;
This will create a new database named universityHousingDB which the application will use to store all data.

2. **Configure Application Properties** 📝:
   Open the `application.properties` file located in `src/main/resources/` and update the database connection properties to match your environment:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/universityHousingDB
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword

3. **Running the Application** 🚀:
   After setting up the database, you can run the application by executing the following commands in your terminal:
   
   ```bash
   git clone https://github.com/yourgithubusername/UniversityHostelReservationSystem.git
   cd UniversityHostelReservationSystem
   ./mvnw spring-boot:run
4. **Access Swagger UI**:
   Once the application is running, access the Swagger UI to interact with the API at:
   [http://localhost:8083/universityHousing/swagger-ui/](http://localhost:8083/universityHousing/swagger-ui/)

## 🌟 Conclusion
This project showcases my skills in Java development, specifically with the Spring Boot framework. Through the development of the University Hostel Reservation System, I have demonstrated a comprehensive understanding of building robust and scalable web applications. This encompasses key aspects such as database interaction and API management, underlining my ability to handle complex backend systems effectively.
