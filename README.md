# Book API Project

## Overview
This project is a RESTful API for managing a collection of books. It is built using Spring Boot and provides full CRUD (Create, Read, Update, Delete) operations. The backend uses MySQL for data persistence.

## Features
- **Create a Book**: Add a new book to the collection.
- **Read Books**: Retrieve a list of all books or a specific book by its ID.
- **Update a Book**: Modify the details of an existing book.
- **Delete a Book**: Remove a book from the collection.

## Technologies Used
- **Java**: Programming language used for development.
- **Spring Boot**: Framework used for building the RESTful API.
- **MySQL**: Database used for storing book information.
- **Maven**: Build and dependency management tool.

## Getting Started
### Installation

1. **Clone the repository**

### Create a database named bookdb.
Update the application.yml file with your MySQL credentials.
properties

#### mvn clean install
#### mvn spring-boot:run

## API Endpoints

### Create a Book
- **Endpoint**: `/api/books`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "ISBN Number",
    "publishedDate": "YYYY-MM-DD"
  }
  
### Get All Books
- **Endpoint**: `/api/books`
- **Method**: `GET`

### Get a Book by ID
- **Endpoint**: `/api/books/{id}`
- **Method**: `GET`
- **Additional**: `You can use search queries to filter books by title, author name, or publication year.`
- **Endpoint**:  `http://localhost:8080/books/search?query=<your-query-here> ` 

### Update a Book
- **Endpoint**: `/api/books/{id}`
- **Method**: `PUT`
- **Request Body**:
  ```json
  {
    "title": "Updated Book Title",
    "author": "Updated Author Name",
    "isbn": "Updated ISBN Number",
    "publishedDate": "YYYY-MM-DD"
  }

### Delete a  Book by ID
- **Endpoint**: `/api/books/{id}`
- **Method**: `DEL`

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Spring Boot documentation
- MySQL documentation

## Contact

For any inquiries or issues,please connect with me on [LinkedIn](https://www.linkedin.com/in/adeshina-adesola-48040b20a/).
