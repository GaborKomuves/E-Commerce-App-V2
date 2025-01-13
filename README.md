E-commerce Application Overview
This project is a back-end implementation of an e-commerce application that leverages Spring Boot, PostgreSQL, and Postman for testing API endpoints. The application is designed to handle core e-commerce functionalities such as user management, product management, cart management, and order processing, adhering to CRUD principles and RESTful API standards.

Technologies Used
Spring Boot: For developing the back-end REST APIs.
PostgreSQL: As the relational database to store application data.
Postman: For testing and simulating API requests.
Java: As the programming language for business logic implementation.
Core Features
User Management:

Create User: Add new users with fields like firstname, lastname, username, password, email, and role.
Read User(s): Fetch details of all users or a specific user.
Update User: Modify user details.
Delete User: Remove a user from the system.
Product Management:

Create Product: Add new products with details such as name, price, and category.
Read Product(s): Fetch details of all products or specific ones based on filters like category or price.
Update Product: Modify product details.
Delete Product: Remove a product.
Cart Management:

Add to Cart: Add items to a user's shopping cart.
View Cart: Retrieve all items in a user's cart.
Update Cart: Modify quantities of items in the cart.
Delete Item: Remove an item from the cart.
Order Management:

Create Order: Place an order for items in the cart.
Read Orders: Fetch details of all orders or specific orders by user.
Update Order Status: Modify the status of an order (e.g., Pending, Shipped).
Delete Order: Cancel an order.
API Documentation (Examples)
User API
Endpoint: POST /api/users
Description: Creates a new user.
Request Body:
![image](https://github.com/user-attachments/assets/c961b23e-96e6-47cd-a5e2-d453e5d73501)
Description users table:
![image](https://github.com/user-attachments/assets/b2b1b15d-3740-40bd-88f4-688c59387afd)

