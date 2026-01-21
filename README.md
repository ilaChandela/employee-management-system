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

## 📂 Project Structure

com.example.ems
  -controller
  -service
  -repository
  -entity
  -dto
    -request
    -response
  -mapper
  
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

### Create Employee
POST /api/employees


```json
{
  "firstName": "Aman",
  "lastName": "Verma",
  "email": "aman@ems.com",
  "salary": 60000,
  "hireDate": "2024-02-01",
  "departmentId": 1,
  "jobId": 1
}

⚙️ Configuration(already Done)
application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ems_db
    username: ems_user
    password: ems_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

server:
  port: 8080
