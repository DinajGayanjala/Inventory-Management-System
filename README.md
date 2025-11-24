🏪 Inventory Management System
<div align="center">
https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white
https://img.shields.io/badge/Java_Swing-6DB33F?style=for-the-badge&logo=java&logoColor=white
https://img.shields.io/badge/PDF_Generation-FF0000?style=for-the-badge&logo=adobeacrobatreader&logoColor=white

A comprehensive desktop application for managing inventory, sales, and customer relationships

</div>
📋 Table of Contents
Features

Technology Stack

System Architecture

Installation

Database Setup

Team Members

Module Details

Usage Guide

✨ Features
🔐 Authentication & Security
Role-based access control (Admin/User)

Secure login system with database validation

User management with CRUD operations

Password security and session management

📦 Product Management
Category management with hierarchical organization

Product catalog with inventory tracking

Stock management with quantity alerts

Price management and product descriptions

🛒 Order Processing
Customer management with contact details

Shopping cart system with real-time calculations

Order processing with invoice generation

PDF invoice generation using iText library

📊 Reporting & Analytics
Order history viewing

Sales reporting and analytics

Customer order tracking

Inventory status reports

🖥️ User Interface
Intuitive desktop interface using Java Swing

Role-based dashboard with customized navigation

Responsive design with modern UI components

Easy navigation between modules

🛠 Technology Stack
Component	Technology
Frontend	Java Swing (GUI)
Backend	Java 8+
Database	MySQL 5.7+
PDF Generation	iText PDF Library
Architecture	MVC Pattern
Build Tool	Standard Java Project
🏗 System Architecture
text
Presentation Layer (Java Swing)
         ↓
Business Logic Layer (Java Classes)
         ↓
Data Access Layer (JDBC)
         ↓
Database Layer (MySQL)
Module Flow:
text
Login → Dashboard → [Products | Orders | Customers | Users] → Reports
📥 Installation
Prerequisites
Java JDK 8 or higher

MySQL Server 5.7 or higher

Git (for version control)

Step 1: Clone Repository
bash
git clone https://github.com/your-username/inventory-management-system.git
cd inventory-management-system
Step 2: Database Setup
bash
# Create database (run in MySQL)
CREATE DATABASE inventory;

# Run table creation (from project)
java -cp . src/infc/code/table.java
Step 3: Configure Database
Edit src/infc/code/dbconnect.java:

java
// Update connection parameters if needed
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/inventory?useSSL=false", 
    "root", 
    "your_password"
);
Step 4: Run Application
bash
# Compile and run
javac -cp . src/infc/Infc.java
java -cp . infc.Infc

# Or run directly from IDE
🗃 Database Setup
Automatic Setup
Run the table creation utility:

java
// Execute table.java to create all required tables
src/infc/code/table.java
Manual Setup (if needed)
sql
-- Create database
CREATE DATABASE inventory;

-- Use the database
USE inventory;

-- Create tables (executed automatically by table.java)
-- Users table
CREATE TABLE appuser1 (
    appuser_pk INT AUTO_INCREMENT PRIMARY KEY,
    userRole VARCHAR(50) NOT NULL,
    name VARCHAR(200) NOT NULL,
    mobileNumber VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255) NOT NULL,
    address TEXT,
    status VARCHAR(50) DEFAULT 'Active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert default admin user
INSERT INTO appuser1 (userRole, name, mobileNumber, email, password, address, status) 
VALUES ('Admin', 'System Administrator', '1234567890', 'admin@inventory.com', 'admin123', 'System Address', 'Active');
👥 Team Members
Member	Role	Responsibilities
Member 1	Database & Core Infrastructure	Database connection, utilities, table creation, main class
Member 2	Authentication & Security	Login system, user management, PDF utilities
Member 3	Product Management	Category management, product catalog, inventory tracking
Member 4	Order Processing	Order management, customer management, invoice generation
Member 5	UI & Reporting	Main dashboard, navigation, order viewing, reports
📁 Module Details
Core Modules:
dbconnect.java - Database connection management

login.java - User authentication system

home.java - Main dashboard with navigation

manageuse.java - User management CRUD

managecatogery.java - Category management

manageproduct.java - Product inventory management

mangeorder.java - Order processing with PDF invoices

managecustomer.java - Customer relationship management

vieworder.java - Order history and reporting

openpdf.java - PDF generation utilities

🚀 Usage Guide
Default Login Credentials
text
Email: admin@inventory.com
Password: admin123
Getting Started
Launch Application: Run Infc.java

Login: Use default credentials or create new user

Navigate: Use dashboard buttons to access different modules

Manage Products: Add categories and products

Process Orders: Create orders for customers

Generate Reports: View order history and invoices

Key Operations:
Add New Product: Products → Add Product

Create Order: Orders → New Order

Manage Users: Users → Manage Users

View Reports: Reports → Order History

🔧 Troubleshooting
Common Issues:
Database Connection Failed

Verify MySQL service is running

Check database credentials in dbconnect.java

Ensure database 'inventory' exists

PDF Generation Error

Check write permissions in bill directory

Verify iText library is included

Login Issues

Verify default user exists in database

Check user status is 'Active'

Support:
For issues and questions, contact the development team or check the GitHub issues page.

📄 License
This project is licensed under the MIT License - see the LICENSE.md file for details.

🤝 Contributing
Fork the project

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📞 Contact
Development Team - inventory-team@example.com

Project Link: https://github.com/your-username/inventory-management-system

<div align="center">
🚀 Happy Inventory Managing!
Built with ❤️ by a dedicated team of 5 developers

</div>
