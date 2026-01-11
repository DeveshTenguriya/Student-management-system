🎓 Student Management System
Secure REST API with Spring Boot & JWT Authentication










🚀 Project Overview

Student Management System is a production-ready backend application built using Spring Boot, following clean architecture and industry best practices.

The project goes beyond basic CRUD by implementing secure authentication and authorization using Spring Security and JWT, making it a real-world backend system suitable for enterprise-level applications.

This project demonstrates strong backend fundamentals such as:

REST API design

Secure user authentication

Password encryption

JWT-based stateless security

Database integration

Clean, maintainable code structure

✨ Key Features
📚 Student Management

✔ Create, Read, Update, Delete (CRUD) student records
✔ DTO-based request & response handling
✔ Pagination support
✔ Clean Controller → Service → Repository layering

🔐 Security & Authentication

✔ User registration with BCrypt password hashing
✔ Secure login using Spring Security AuthenticationManager
✔ JWT token generation on successful login
✔ Stateless authentication (no sessions)
✔ Custom JWT authentication filter
✔ Role-ready architecture for authorization

🧠 Authentication & Security (JWT)

This application uses Spring Security with JWT (JSON Web Token) for secure, stateless authentication.

🔄 Authentication Flow
REGISTER
↓
Password → BCrypt Hash → Database

LOGIN
↓
Username + Password
↓
Spring Security AuthenticationManager
↓
JWT Token Generated

SECURED API REQUEST
↓
Authorization: Bearer <JWT>
↓
JWT Filter → User Authenticated

🔑 Authentication APIs
🟢 Register User
POST /auth/register


Request Body

{
"username": "devesh",
"password": "password123"
}


✔ Password is encrypted using BCrypt
✔ User credentials are securely stored in the database

🟢 Login User
POST /auth/login


Request Body

{
"username": "devesh",
"password": "password123"
}


Response

{
"token": "eyJhbGciOiJIUzI1NiJ9..."
}


✔ Credentials validated against database
✔ JWT token returned on successful authentication

🔒 Secured APIs

All student-related APIs are protected.

Request Header

Authorization: Bearer <JWT_TOKEN>


Example:

GET /api/v1/student


❌ Without JWT → 401 Unauthorized
✅ With valid JWT → Access granted

🛠️ Tech Stack
Layer	Technology
Language	Java 17
Framework	Spring Boot
Security	Spring Security + JWT
Persistence	Spring Data JPA
Database	PostgreSQL
Authentication	BCrypt Password Encoder
Build Tool	Maven


📂 Project Structure
src/main/java/com/example/studentmanagement
│
├── controller
│   ├── StudentController.java
│   └── AuthController.java
│
├── service
│   ├── StudentService.java
│   └── AuthService.java
│
├── repository
│   ├── StudentRepository.java
│   └── UserRepository.java
│
├── security
│   ├── JwtAuthenticationFilter.java
│   ├── JwtService.java
│   └── SecurityConfig.java
│
├── dto
│   ├── StudentRequestDTO.java
│   ├── StudentResponseDTO.java
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── entity
│   ├── Student.java
│   ├── User.java
│   └── Role.java
│
└── StudentManagementApplication.java

📥 Getting Started (Run Locally)
✅ Prerequisites

Java 17+

Maven

PostgreSQL

📦 Clone Repository
git clone https://github.com/DeveshTenguriya/Student-management-system.git
cd Student-management-system

⚙️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/studentsystem
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

▶️ Run Application
mvn spring-boot:run


Server starts at:

http://localhost:8080

🧪 Student APIs
Method	Endpoint	Description
GET	/api/v1/student	Fetch all students
POST	/api/v1/student	Add new student
PUT	/api/v1/student/{id}	Update student
DELETE	/api/v1/student/{id}	Delete student

🔐 All endpoints require JWT authentication.

🧠 What This Project Demonstrates

✅ Secure backend development using Spring Boot
✅ JWT-based authentication & authorization
✅ Proper password handling with BCrypt
✅ Clean layered architecture
✅ Production-ready coding practices
✅ Interview-ready real-world backend project

🚀 Future Enhancements

✔ Role-based authorization (ADMIN / USER)
✔ Swagger (OpenAPI) documentation
✔ Dockerization
✔ Unit & integration tests
✔ Refresh token support

👨‍💻 Author

Devesh Tenguriya
Backend Developer | Java | Spring Boot

📧 Email: deveshtenguriya8220@gmail.com

🔗 GitHub: https://github.com/DeveshTenguriya

🔗 LinkedIn: https://linkedin.com/in/devesh-tenguriya-92a976356/

📄 License

This project is licensed under the MIT License.

⭐ Support

If you find this project useful or educational, please star ⭐ the repository — it really helps!