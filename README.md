* 🚗 **RideService** — Manages cars and ride data (MongoDB)
* 💬 **UserMessagingService** — Handles user communication (e.g., notifications, messaging)

---

# 🛠️ Ride & Messaging Microservices Backend

This project is a modular backend system built with Spring Boot, consisting of **two microservices**:

1. **RideService** — For managing cars and ride-related operations
2. **UserMessagingService** — For handling user notifications or messaging functionality

The services are decoupled, independently deployable, and communicate over REST APIs (can be extended to Kafka, RabbitMQ, etc.).

---

## 🚀 Services Overview

### 1. 🚗 RideService

Manages:

* Car information
* Ride creation and lifecycle
* MongoDB persistence

\| Endpoint Base | `/cars`, `/rides` |
\| Persistence   | MongoDB |
\| Status        | ✅ Working |

### 2. 💬 UserMessagingService

Manages:

* Sending notifications/messages
* User communication workflows
* Email (via Spring Mail), or WebSocket (optional)

\| Endpoint Base | `/messages`, `/notifications` (example) |
\| Persistence   | MongoDB or in-memory |
\| Status        | ✅ Working (customize endpoints accordingly) |

---

## ⚙️ Tech Stack

* Java 21
* Spring Boot 3.4.x
* MongoDB
* Spring Web
* Spring Boot Mail / WebSocket (UserMessaging)
* MapStruct
* Lombok
* Maven

---

## 🗂️ Project Structure

```
project-root/
├── rideservice/               # Car & Ride microservice
│   └── src/main/java/com/droovo/tn/rideservice
│       ├── Controllers
│       ├── Services
│       ├── Repositories
│       ├── DTO, Entities
|       ├── Mappers
│       └── Application.java
│
├── usermessagingservice/     # Messaging microservice
│   └── src/main/java/com/droovo/tn/usermessaging
│       ├── Controllers
│       ├── Services
│       ├── DTOs, Entities
|       ├── Mappers
│       └── Application.java
```

---

## 🧪 Local Setup

> Make sure MongoDB is running locally or update connection strings.

### Prerequisites

* Java 21+
* Maven 3.9+
* MongoDB

### Clone the Repo

```bash
git clone https://github.com/ImeedAttia/D2.git
cd microservices-backend
```

### Build & Run Each Microservice

**RideService:**

```bash
cd rideservice
mvn clean install
mvn spring-boot:run
```

**UserMessagingService:**

```bash
cd ../usermessagingservice
mvn clean install
mvn spring-boot:run
```

---

## 🧩 APIs (High-level)

### 🚘 RideService

| Method | Endpoint      | Description   |
| ------ | ------------- | ------------- |
| POST   | `/cars`       | Add a car     |
| GET    | `/cars/{id}`  | Get car by ID |
| POST   | `/rides`      | Create ride   |
| PATCH  | `/rides/{id}` | Update ride   |
| GET    | `/rides`      | Get all rides |

### 💬 UserMessagingService (Example)

| Method | Endpoint             | Description             |
| ------ | -------------------- | ----------------------- |
| POST   | `/messages`          | Send message            |
| GET    | `/messages/{userId}` | Get messages for a user |
| POST   | `/notifications`     | Send user notification  |

---

## 🛡️ Security

* CORS enabled for all domains (adjust as needed)
* No authentication by default (suggest JWT or OAuth2 for production)

---

## 🌐 Deployment Tips

* Use Docker Compose or Kubernetes for deploying services together
* API Gateway (like Spring Cloud Gateway or NGINX) recommended
* Service discovery (e.g., Eureka, Consul) optional for scaling

---

## 📬 Future Improvements

* Add Kafka/RabbitMQ between services for async messaging
* Integrate Swagger/OpenAPI for both services
* Add central config server (Spring Cloud Config)

---

## 📄 License

This project is licensed under the MIT License.
* 📄 **License:** [MIT License](https://droovo.tn/privacy-policy)
* 🌐 **Project Website:** [https://droovo.tn](https://droovo.tn)

---
