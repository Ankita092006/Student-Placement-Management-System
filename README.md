# Student Placement Management System

A **Java-based Student Placement Management System** developed using **Java Swing, OOP, JDBC, and MySQL**. The project provides a graphical user interface (GUI) for students and administrators to manage the college placement process.

## 📌 Project Overview

The Student Placement Management System helps students view available companies, check job eligibility, apply for jobs, and track their application status.

Administrators can manage companies and monitor student applications through an admin dashboard.

## ✨ Features

### 👨‍🎓 Student

* Student Registration
* Student Login
* Student Profile Management
* View Available Companies
* Search Companies and Job Roles
* Check CGPA Eligibility
* Apply for Jobs
* View Application Status
* Logout

### 👨‍💼 Admin

* Admin Login
* Admin Dashboard
* Add Companies
* View Companies
* View Student Applications
* Update Application Status
* Manage Placement Information

## 🛠️ Technologies Used

* **Java**
* **Java Swing** – Graphical User Interface
* **OOP** – Object-Oriented Programming
* **JDBC** – Database Connectivity
* **MySQL** – Database
* **Git & GitHub** – Version Control
* **VS Code** – Development Environment

## 📂 Project Structure

```text
Student-Placement-Management-System
│
├── src
│   ├── Main.java
│   │
│   ├── model
│   │   ├── Student.java
│   │   ├── Company.java
│   │   ├── Application.java
│   │   └── Admin.java
│   │
│   ├── database
│   │   └── DBConnection.java
│   │
│   ├── dao
│   │   ├── StudentDAO.java
│   │   ├── CompanyDAO.java
│   │   ├── ApplicationDAO.java
│   │   └── AdminDAO.java
│   │
│   ├── service
│   │   ├── AuthService.java
│   │   ├── PlacementService.java
│   │   ├── StudentService.java
│   │   ├── CompanyService.java
│   │   └── Session.java
│   │
│   └── ui
│       ├── LoginFrame.java
│       ├── RegisterFrame.java
│       ├── StudentDashboard.java
│       ├── StudentProfileFrame.java
│       ├── CompanyFrame.java
│       ├── ApplicationFrame.java
│       ├── AdminLoginFrame.java
│       └── AdminDashboard.java
│
├── lib
│   └── mysql-connector-j.jar
│
├── .gitignore
└── README.md
```

## 🗄️ Database

The project uses **MySQL** with the following main tables:

* `students`
* `companies`
* `applications`
* `admins`

### Database Name

```sql
placement_system
```

### Main Relationships

```text
Students
   │
   │
   └──── Applications ──── Companies
                │
                └──── Application Status
```

## ⚙️ Setup and Installation

### 1. Install Java

Install **JDK 17 or later**.

Check the installation:

```bash
java -version
javac -version
```

### 2. Install MySQL

Create the database:

```sql
CREATE DATABASE placement_system;
```

Then create the required tables for students, companies, applications, and admins.

### 3. Configure Database Connection

Open:

```text
src/database/DBConnection.java
```

Update your MySQL username and password:

```java
private static final String USER = "root";
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

**Do not upload your real database password to GitHub.**

### 4. Add MySQL Connector

Place the MySQL Connector/J `.jar` file inside:

```text
lib/
```

Example:

```text
lib/mysql-connector-j-9.x.x.jar
```

### 5. Compile the Project

From the project root:

```bash
javac -cp "lib/mysql-connector-j-9.x.x.jar" -d out src/Main.java src/database/*.java src/model/*.java src/dao/*.java src/service/*.java src/ui/*.java
```

### 6. Run the Project

```bash
java -cp "out;lib/mysql-connector-j-9.x.x.jar" Main
```

## 🖥️ Graphical User Interface

The application uses **Java Swing** to provide a simple graphical user interface.

Main screens include:

* Student Login
* Student Registration
* Student Dashboard
* Student Profile
* Company Listing
* Job Application
* Admin Login
* Admin Dashboard

## 🔄 Application Flow

```text
Start Application
       ↓
    Login
   ↙     ↘
Student   Admin
   ↓        ↓
Dashboard  Dashboard
   ↓        ↓
View Jobs  Manage Companies
   ↓        ↓
Apply Job  Manage Applications
   ↓
Track Status
```

## 📊 Application Status

The system can maintain different application statuses:

```text
Applied
   ↓
Shortlisted
   ↓
Selected / Rejected
```

## 🎯 Objective

The main objective of this project is to develop a simple and efficient placement management system that connects students, companies, and administrators through a centralized application.

## 🚀 Future Enhancements

* Password hashing and improved security
* Resume upload
* Email notifications
* Placement statistics and charts
* Advanced job filtering
* Student placement history
* Company-wise placement reports
* Improved modern GUI
* Role-based access control

## 👩‍💻 Author

**Ankita Sasmal**

Java | OOP | JDBC | MySQL | Swing
