
▶️ Steps to Run This Project in IntelliJ IDEA

1️⃣ Required Software 

Make sure the following are installed before opening the project:

Java JDK 21

IntelliJ IDEA (Community or Ultimate)

MySQL Server

Git

2️⃣ Clone the Project from GitHub

Open IntelliJ IDEA

Click File → New → Project from Version Control

Select Git

Paste the GitHub repository URL

Click Clone

The project will open automatically.

3️⃣ Set Project JDK in IntelliJ

Go to File → Project Structure

Under Project:

Project SDK: Java 21

Project language level: 21

Click Apply → OK

4️⃣ Load Maven Dependencies

This project uses Maven Wrapper.

IntelliJ will detect pom.xml

Click “Load Maven Project”

Wait until all dependencies finish downloading

If needed, manually refresh:

Maven Tool Window → Reload All Maven Projects

5️⃣ Database Setup (MySQL)

1) Open MySQL as Root(in terminal):-

sudo mysql

2) Create Database:-
CREATE DATABASE ems;

3) Create User with Password:-
CREATE USER 'ems_user'@'localhost' IDENTIFIED BY 'ems_password';

4) Give User Access to Database:-

GRANT ALL PRIVILEGES ON ems.* TO 'ems_user'@'localhost';
FLUSH PRIVILEGES;

EXIT;

5) Login using the new user:-

mysql -u ems_user -p


Enter password:

ems_password


If you see:

mysql>
 
✅ User and password are correct.

6️⃣ Configure Environment Variables

This project uses a .env file with spring-dotenv.

Open the file:

ems/.env


Set the database values (example):

DB_URL=jdbc:mysql://localhost:3306/ems
DB_USERNAME=ems_user
DB_PASSWORD=ems_password

7️⃣ Locate Main Application Class

Path:

src/main/java/com/example/ems/EmployeeManagementSystemApplication.java


Main class:

@SpringBootApplication
public class EmployeeManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }
}

8️⃣ Run the Project in IntelliJ

Right-click on
EmployeeManagementSystemApplication

Click Run 'EmployeeManagementSystemApplication'


9️⃣ Verify Application Startup

In IntelliJ Run Console, you should see logs similar to:

Tomcat started on port(s): 8080
Started EmployeeManagementSystemApplication


# Employee Management System (EMS)

A backend **Employee Management System** built using **Spring Boot, Spring Data JPA, and MySQL**.  
This project is designed for learning and practicing **real-world backend architecture**, including DTOs, mappers, layered design, and relational database modeling.

---

## 🚀 Features

- Employee management (CRUD)
- Department management
- Job role management
- Project management
- Assign employees to projects (Many-to-Many)
- Clean separation using DTOs and Mappers
- RESTful APIs
- MySQL database integration

---

## 🛠️ Tech Stack

- **Java 21+**
- **Spring Boot 4**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**
- **Postman (API testing)**
- **IntelliJ IDEA**
- **Ubuntu (Linux)**
  
---

## 🗄️ Database Design

### Entities

- **Employee**
- **Department**
- **Job**
- **Project**
- **EmployeeProject** (Join table)

### Relationships

- Department → One-to-Many → Employee  
- Job → One-to-Many → Employee  
- Employee ↔ Many-to-Many ↔ Project (via EmployeeProject)

---

✔ Entities are **never exposed directly** to APIs  
✔ DTOs are used for request & response  
✔ Business logic lives in Service layer  

---

## 📮 Sample API Endpoints

✅ 1️⃣ Add Department
Endpoint
POST http://localhost:8080/api/departments

JSON Body
{
  "name": "IT",
  "location": "Ahmedabad"
}

✅ Another Department Example
{
  "name": "HR",
  "location": "Delhi"
}

✅ 2️⃣ Add Job
Endpoint
POST http://localhost:8080/api/jobs

JSON Body
{
  "title": "Backend Developer",
  "minSalary": 30000,
  "maxSalary": 100000
}

✅ Another Job Example
{
  "title": "Frontend Developer",
  "minSalary": 25000,
  "maxSalary": 90000
}

✅ 3️⃣ Add Employee 

✅ Employee Create Request
Endpoint
POST http://localhost:8080/api/employees

JSON Body (EmployeeRequestDto)
{
  "firstName": "Aman",
  "lastName": "Verma",
  "email": "aman@ems.com",
  "salary": 60000,
  "hireDate": "2024-02-01",
  "departmentId": 1,
  "jobId": 1
}

✅ Expected Employee Response
{
  "id": 1,
  "firstName": "Aman",
  "lastName": "Verma",
  "email": "aman@ems.com",
  "salary": 60000,
  "hireDate": "2024-02-01",
  "department": {
    "name": "IT",
    "location": "Ahmedabad"
  },
  "job": {
    "id": 1,
    "title": "Backend Developer",
    "minSalary": 30000,
    "maxSalary": 100000
  }
}

