# Backend - Java/React Technical Test

This is the backend component of the Java/React technical test. It provides the server-side implementation for creating, managing, and retrieving bookings and blocks for a property management system.
Technologies Used

    Java (11 or newer)
    Spring Boot
    Maven

# Setup Instructions

To run the backend application locally, follow these steps:

    Make sure you have Java 11 or a newer version installed on your machine.

    Clone the repository or download the source code.

    Open the project in your preferred IDE (such as IntelliJ IDEA).

    Build the project using Maven to download the required dependencies.

    Locate the main class BackendApplication.java and run it to start the backend server.

    The backend server will start running on http://localhost:8080.

# API Endpoints

The following API endpoints are available for interacting with the backend:

    POST /bookings - Create a new booking.
    GET /bookings/{bookingId} - Get a booking by ID.
    DELETE /bookings/{bookingId} - Cancel a booking.
    PUT /bookings/{bookingId} - Rebook a booking with updated details.

    Following API endpoints are available through Swagger UI
    
    POST /blockings - Create a new booking.
    GET /blockings/{blockingId} - Get a booking by ID.
    DELETE /blockings/{blockingId} - Cancel a booking.
    PUT /blockings/{blockingId} - Rebook a booking with updated details.

# Data Storage

The backend uses an in-memory database for storing bookings and blocks. This means that the data will not persist between server restarts.

The backend code follows the standard Maven project structure. Here is a brief overview of the important directories:

    src/main/java/com/example/backend - Contains the Java source code for the backend application.
    src/main/resources - Contains the application configuration files and resources.
    src/test - Contains the unit tests for the backend code.

# Contributing

If you would like to contribute to this project, you can fork the repository and create a pull request with your proposed changes. Your contributions are welcome!
License

This project is licensed under the MIT License.

Feel free to update and customize this README file based on your specific project requirements and additional information you want to provide.
