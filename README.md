# 📚 Library Management System - Spring Boot REST API

A backend REST API project built using Spring Boot and MySQL for managing a library system. It provides CRUD operations along with search, sorting, validation, and global exception handling.

---

## 🚀 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Validation

---

## 📌 Features

- Add a new book
- Get all books
- Get book by ID
- Update book details
- Delete book
- Find books by author
- Find books by category
- Sort books by title
- Sort books by price
- DTO pattern implementation
- Manual mapping between Entity and DTO
- Input validation using Bean Validation
- Global exception handling for clean error responses

---

## 🏗️ Project Architecture

The project follows a layered architecture:

Controller → 
Service → 
Repository → 
Entity → 
DTO → 
Mapper → 
Exception Handling

---

## 📡 API Endpoints

### 📘 Book APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/books` | Add a new book |
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by ID |
| PUT | `/books/{id}` | Update book |
| DELETE | `/books/{id}` | Delete book |

---

### 🔍 Search APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/books/author?author=XYZ` | Find books by author |
| GET | `/books/category?category=XYZ` | Find books by category |

---

### 🔃 Sorting APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/books/sort/title` | Sort books by title (A-Z) |
| GET | `/books/sort/price` | Sort books by price |

---

## ⚙️ How to Run the Project

### 1. Clone the repository
```bash
git clone https://github.com/chandu278/library-management-system.git

---
2. Import into IDE
Open in IntelliJ IDEA / Eclipse
Import as Maven project
---
3. Configure Database

Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Run the application
mvn spring-boot:run

📥 Sample Request (Create Book)
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 499,
  "category": "Programming"
}

📤 Sample Response
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 499,
  "category": "Programming"
}

❌ Error Response Example
{
  "timestamp": "2026-06-07T10:30:00",
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Book not found with id: 1",
  "path": "/books/1"
}

🎯 Learning Outcomes
- Building REST APIs using Spring Boot
- Layered architecture design
- DTO pattern implementation
- Global exception handling
- Input validation using annotations
- Sorting and filtering using Spring Data JPA

👨‍💻 Author
GitHub: chandu278

