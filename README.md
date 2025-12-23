## Project
Personal Expense Tracker (Console-based)
## Project description
The Personal Expense Tracker is a simple Java console application that helps users track their daily expenses.
It allows the user to:
Add new expenses (amount + category + note)
View all expenses
View total spent
View expenses by category
Exit the app


## Refactor: Introduced Service and Repository layers
Separated Repository and Service to make a CRUD design. 

## Concepts used in each class
Enum – Category
Used to restrict category values to a fixed set like FOOD, TRAVEL, RENT, etc.
Prevents invalid category values from being used in the application.

Class – Expense
Encapsulation used by making fields private (amount, category, note, createdAt).
Access to fields is only through getters, not direct access.
Represents a single expense entity used across repository, service, and controller.

Interface – ExpenseRepositoryInterface
Defines a contract (save, findAll, delete, etc.).
Allows switching implementations without changing service code.

Class – ExpenseJSONRepository
Implements ExpenseRepositoryInterface.
Contains file-related logic (JSON read/write using ObjectMapper).
Abstraction used: Service does not know how data is stored (file/db/in-memory)
ObjectMapper (Jackson) Converts:
JSON → Java (readValue)
Java → JSON (writeValue)
Abstracts low-level JSON parsing logic

Class – ExpenseService
Contains business logic (total calculation, delete validation, filtering).
Dependency Injection used via constructor - public ExpenseService(ExpenseRepositoryInterface repo)
Service does not create repository, it only uses it.

Class – ExpenseController
Acts as API layer using @RestController.
Uses annotations like @PostMapping, @GetMapping, @DeleteMapping.
Converts HTTP requests → service calls.
Uses DTO instead of entity to accept input safely

DTO – ExpenseRequestDTO
Used to separate API input from domain model.
Validation annotations applied here (@Positive, @NotNull, etc.).
Prevents invalid data from reaching Expense model.  

Mapper Logic (DTO → Entity)
Conversion from DTO to Expense happens in Controller or Service.
This is where data transformation responsibility is handled.

Class – GlobalExceptionHandler
Uses @RestControllerAdvice.
Centralized exception handling for: Validation errors, Illegal arguments
Converts exceptions into clean HTTP responses instead of stack traces

Class – ExpenseTrackerApplication
Contains the main() method.
Used to bootstrap and start the Spring Boot application.

## Move from file -> Databse using JPA + SQL
Remove below
JSON file handling
ObjectMapper - file read/write logic
Manual List<Expense> storage