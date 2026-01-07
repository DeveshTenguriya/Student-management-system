🎓 Student Management System (Spring Boot)

A production-ready Student Management System REST API built using Spring Boot following clean architecture, layered design, and industry best practices.
This project demonstrates real-world backend development skills including RESTful APIs, DTO mapping, database integration, and proper project structuring.

🚀 Features

Create, Read, Update, Delete (CRUD) Students

Course management (extendable)

RESTful API design

DTO pattern for request & response

ModelMapper for clean object mapping

PostgreSQL database integration

Validation & exception handling

Layered architecture (Controller → Service → Repository)

Ready for future enhancements (JWT, pagination, roles)

🛠️ Tech Stack
Technology	Description
Java	Java 17+
Spring Boot	Backend framework
Spring Web	REST API development
Spring Data JPA	ORM & database access
Hibernate	JPA implementation
PostgreSQL	Relational database
ModelMapper	DTO ↔ Entity mapping
Maven	Dependency management
Postman	API testing
📂 Project Structure
com.example.studentmanagement
│
├── controller
│   ├── StudentController.java
│   ├── CourseController.java
│
├── service
│   ├── StudentService.java
│   ├── CourseService.java
│
├── repository
│   ├── StudentRepository.java
│   ├── CourseRepository.java
│
├── dto
│   ├── StudentRequestDTO.java
│   ├── StudentResponseDTO.java
│
├── entity
│   ├── Student.java
│   ├── Course.java
│
├── config
│   ├── ModelMapperConfig.java
│
└── StudentManagementApplication.java


✔️ Follows standard enterprise-level Spring Boot architecture

🗄️ Database Schema
Student Table
Column	Type
id	BIGINT (PK)
name	VARCHAR
email	VARCHAR (Unique)
dob	DATE
age	INTEGER
🔗 API Endpoints
Student APIs
Method	Endpoint	Description
GET	/api/v1/student	Get all students
POST	/api/v1/student	Create new student
PUT	/api/v1/student/{id}	Update student
DELETE	/api/v1/student/{id}	Delete student
Example PUT Request
PUT http://localhost:8080/api/v1/student/1?name=Sakura&email=sakura@gmail.com

⚙️ Configuration
application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentsystem
spring.datasource.username=project1
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

▶️ How to Run the Project
Prerequisites

Java 17+

Maven

PostgreSQL

IntelliJ IDEA / VS Code

Steps
# Clone repository
git clone https://github.com/your-username/student-management-system.git

# Navigate to project
cd student-management-system

# Run application
mvn spring-boot:run


Application will start at:

http://localhost:8080

🧪 Testing

API tested using Postman

Validations handled at service level

Clean separation of concerns for easy testing

📈 Future Enhancements

JWT Authentication & Authorization

Role-based access (Admin / User)

Swagger (OpenAPI) documentation

Dockerization

Unit & Integration Tests

🧠 What This Project Demonstrates

✅ Real-world Spring Boot development
✅ Clean code & best practices
✅ REST API design
✅ Database integration
✅ DTO & mapping concepts
✅ Resume-ready backend project

👨‍💻 Author

Devesh Tenguriya
Backend Developer | Java | Spring Boot

📧 Email: deveshtenguriya8220@gmail.com
🔗 GitHub: https://github.com/DeveshTenguriya
🔗 LinkedIn: https://www.linkedin.com/in/devesh-tenguriya-92a976356/
