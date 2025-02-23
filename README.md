# 🚀 E-Commerce API

This project is a **Spring Boot-based E-Commerce API** that enables users to manage products, orders, and user authentication. The API provides endpoints for **user registration**, **product management**, **cart operations**, and **order processing**.

![Postman Request](https://your-image-host.com/image1.png)

---

## 🌟 Features
✅ **User Management**: Register users with different roles (**ADMIN, USER**).  
✅ **Product Management**: CRUD operations on products.  
✅ **Cart Operations**: Add and remove items from the shopping cart.  
✅ **Order Management**: Create and retrieve orders.  
✅ **Search & Filter**: Search for products by **name, category, price, stock level**.  
✅ **Security**: Role-based access control (**RBAC**) implementation.  

![Postman Response](https://your-image-host.com/image2.png)

---

## 🛠️ Technologies Used
🔹 **Spring Boot** (Backend Framework)  
🔹 **Spring Security** (Authentication & Authorization)  
🔹 **PostgreSQL** (Database)  
🔹 **Maven** (Dependency Management)  
🔹 **Postman** (API Testing)  

---

## 📥 Installation & Setup

### 🔹 Prerequisites
Ensure you have the following installed:
- 🖥️ **Java 17+**
- 🏗️ **Maven**
- 🗄️ **PostgreSQL**
- 🛠️ **Postman** (for API testing)

### 🔹 Steps to Run

1️⃣ **Clone the repository**
   ```sh
   git clone https://github.com/your-repository/ecommerce-api.git
   cd ecommerce-api
   ```

2️⃣ **Configure the Database**  
   Edit `application.properties` (or `application.yml`) with your PostgreSQL credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3️⃣ **Build and Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

4️⃣ **Test the Endpoints**  
   Use **Postman** or **cURL** to interact with the API.

---

## 🔗 API Endpoints

### 🧑‍💼 User Management
| Method | Endpoint      | Description        |
|--------|-------------|-----------------|
| `POST` | `/api/users` | ➕ Create a new user |
| `GET`  | `/api/users` | 📂 Retrieve all users |

### 🛒 Product Management
| Method | Endpoint            | Description          |
|--------|---------------------|----------------------|
| `POST` | `/api/products`     | ➕ Add a new product   |
| `GET`  | `/api/products`     | 📂 Retrieve all products |
| `GET`  | `/api/products/{id}` | 🔍 Get a product by ID |
| `PUT`  | `/api/products/{id}` | ✏️ Update a product   |
| `DELETE` | `/api/products/{id}` | ❌ Delete a product  |

### 📦 Cart & Order Management
| Method | Endpoint            | Description         |
|--------|---------------------|---------------------|
| `POST` | `/api/cart/add`     | 🛍️ Add item to cart   |
| `GET`  | `/api/cart/{userId}` | 🛒 Get cart items for a user |
| `POST` | `/api/orders`       | 📦 Create an order    |
| `GET`  | `/api/orders`       | 📂 Retrieve all orders |

---

## 🔐 Authentication
- The API supports **role-based authentication**.
- Users can register and log in with **ADMIN** or **USER** roles.

📌 **Example JSON Payload for User Registration:**
```json
{
  "firstname": "Gabor",
  "lastname": "Komuves",
  "username": "gabor_k",
  "password": "newpassword900",
  "email": "gabor.komuves@gmail.com",
  "role": "ADMIN"
}
```

---

## 📜 License
This project is open-source and available under the **[MIT License](LICENSE)**.

---

## 👥 Contributors
- **Gabor Komuves**
- 📧 **email: gabor.komuves@gmail.com**

---

### 🚀 Happy Coding! 🧑‍💻🎉  

---


Request Body:
![image](https://github.com/user-attachments/assets/c961b23e-96e6-47cd-a5e2-d453e5d73501)
Description users table:
![image](https://github.com/user-attachments/assets/b2b1b15d-3740-40bd-88f4-688c59387afd)

