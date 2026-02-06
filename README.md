# Money Manager (Backend)

The robust Spring Boot backend for the Money Manager application.

## 🚀 Technologies

- **Framework**: Spring Boot 3.2.0
- **Language**: Java 21
- **Database**: MongoDB
- **Build Tool**: Maven

## ⚙️ Configuration

The application is configured to connect to a local MongoDB instance by default.

**`src/main/resources/application.properties`**:
```properties
spring.application.name=money-manager-backend
spring.data.mongodb.uri=mongodb://localhost:27017/money_manager
server.port=8080
```

## 🏃‍♂️ Running Locally

1.  **Prerequisites**:
    - Java 21 SDK installed.
    - Maven installed.
    - MongoDB running locally on port 27017.

2.  **Clone the repository**
    ```bash
    git clone https://github.com/premkumar3616/money-manager-backend.git
    cd money-manager-backend
    ```

3.  **Run with Maven**
    ```bash
    mvn spring-boot:run
    ```
    The server will start at `http://localhost:8080`.

## 📡 API Endpoints

- **GET** `/api/transactions` - Fetch all transactions.
- **POST** `/api/transactions` - Create a new transaction.
- **PUT** `/api/transactions/{id}` - Update a transaction.
- **DELETE** `/api/transactions/{id}` - Delete a transaction.

## ☁️ Deployment

This application can be deployed to any platform supporting Java/Spring Boot (e.g., Heroku, Railway, AWS Elastic Beanstalk).

**Environment Variables for Production**:
Override the properties using environment variables:
- `SPRING_DATA_MONGODB_URI`: Your MongoDB Atlas connection string.
