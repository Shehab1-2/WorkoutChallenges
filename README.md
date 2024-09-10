# Workout Challenge Application

This is a full-stack workout challenge application built using **Java Spring Boot** for the backend and **React** for the frontend. The backend manages workout challenges and stores the data in an **H2 (in-memory SQL) database** using **JPA** and **Hibernate**. The project follows a **Controller-Service-Repository architecture**. **Postman** was used for testing the API endpoints.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Architecture](#project-architecture)
- [Installation and Setup](#installation-and-setup)
- [API Endpoints](#api-endpoints)
- [Testing with Postman](#testing-with-postman)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, update, delete, and view workout challenges.
- Persistent storage of workout challenges using **H2** database (in-memory SQL).
- RESTful API backend built with **Spring Boot**.
- Full controller-service-repository architecture.
- **React** frontend for user interaction.
- API tested using **Postman**.

## Technologies Used

### Backend
- **Java**: Main programming language.
- **Spring Boot**: To build and run the backend server.
- **Spring Data JPA**: For interacting with the H2 database.
- **Hibernate**: ORM framework used with JPA for database interaction.
- **H2 Database**: In-memory SQL database for development and testing purposes.
- **Maven**: Build tool for managing dependencies and running the application.

### Frontend
- **React**: Frontend framework for building the UI.

### Tools
- **Postman**: API testing tool.
  
## Project Architecture

The project follows the **Controller-Service-Repository** architecture to ensure clean separation of concerns.

- **Controller**: Handles HTTP requests, maps URLs to services.
- **Service**: Contains business logic.
- **Repository**: Responsible for direct interaction with the database using **Spring Data JPA** and **Hibernate**.

## Installation and Setup

### Backend Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/your-repository-url
    cd ChallengeApp
    ```

2. Make sure you have **Java 21** and **Maven** installed on your system.

3. Add the necessary dependencies in `pom.xml` for Spring Boot, JPA, Hibernate, and H2 database.

4. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

   This will start the backend on `http://localhost:5001`.

### Frontend Setup

1. Navigate to the frontend directory and install the required dependencies:
    ```bash
    cd frontend
    npm install
    ```

2. Start the React frontend:
    ```bash
    npm start
    ```

   The frontend will be accessible at `http://localhost:3000`.

## API Endpoints

Here are some of the key API endpoints exposed by the backend:

- `GET /challenges`: Fetch all workout challenges.
- `POST /challenges`: Create a new workout challenge.
- `GET /challenges/{id}`: Get details of a specific challenge.
- `PUT /challenges/{id}`: Update an existing challenge.
- `DELETE /challenges/{id}`: Delete a challenge.

Example request body for creating a workout challenge:
```json
{
    "month": "January",
    "description": "Run 10 miles"
}
