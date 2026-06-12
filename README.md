# Online Shopping System (Java & JDBC)

This simple project demonstrates how to connect a Java application to a MySQL database using JDBC to manage the operations of a small online store. The project covers table creation and CRUD operations (adding, modifying, and deleting tables).

## Current Features
* **Database:** Contains basic tables such as (Customers, Products, Orders, Categories, Cart, Payments, Shipments).
* **Security:** Use `PreparedStatement` to prevent SQL Injection attacks.
* **Supported operations in the code:**

  * Add a new category.

* Edit customer address.

* Delete product.

* Add items to order.

* Search for products using a like.

* View orders for a specific customer.


## Technologies Used
* **Language:** Java
* **DataBase:** MySQL
* **Connection:** JDBC Driver

##  (How to Run)
1. Create the database by importing a file`database.sql` in the local server.
2. Make sure to modify the connection details (username and password) in the `dbonlineshopping.java` file to suit your device:



```java
// Database connection credentials
private static final String URL = "jdbc:mysql://localhost:3306/OnlineShoppingSystem";
private static final String USER = "root";  
private static final String PASSWORD = "your_password_here";
