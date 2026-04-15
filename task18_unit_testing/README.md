# Task 18: Unit Testing for Microservices

This project demonstrates comprehensive unit testing for a Spring Boot microservice using **JUnit 5**, **Mockito**, and **MockMvc**.

## Layers Tested

1.  **Service Layer (`BookServiceTest.java`)**:
    *   Tests business logic independently.
    *   Uses `@ExtendWith(MockitoExtension.class)` to mock the `BookRepository`.
    *   Verifies logic for successful saves, duplicate ISBN validation, and price validation.

2.  **Web/Controller Layer (`BookControllerTest.java`)**:
    *   Tests REST endpoints without starting the full HTTP server.
    *   Uses `@WebMvcTest` and `MockMvc`.
    *   Mocks the `BookService` using `@MockBean`.
    *   Validates HTTP status codes (201 Created, 409 Conflict, 404 Not Found) and JSON response content.

3.  **Data Handling Layer (`BookRepositoryTest.java`)**:
    *   Tests repository operations against an in-memory database.
    *   Uses `@DataJpaTest` which configures an H2 database automatically.
    *   Verifies custom query methods like `findByIsbn`.

## How to Run Tests

Ensure you have Maven installed and run the following command in the project root:

```bash
mvn test
```

## Technologies Used
*   Spring Boot Starter Test
*   JUnit Jupiter (JUnit 5)
*   Mockito
*   AssertJ (available via starter-test)
*   H2 In-Memory Database
