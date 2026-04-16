# Currency Converter API

A RESTful API built using Spring Boot to convert currencies using real-time exchange rates. The application also stores conversion history and demonstrates external API integration.

## Features

* Convert currency (e.g., USD → INR)
* API key-based authentication
* Store and retrieve conversion history
* In-memory database using H2
* Integration with external exchange rate API

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* RestTemplate
* Maven

## API Endpoints

### Convert Currency

GET /api/convert?from=USD&to=INR&amount=10

Header:
x-api-key: 12345

### Get Conversion History

GET /api/history

Header:
x-api-key: 12345

## Run Locally

1. Clone the repository
2. Open in Eclipse or any IDE
3. Run `CurrencyConverterApplication`
4. Access APIs via Postman at:
   http://localhost:8081

## Note

This project was developed as part of hands-on learning of Spring Boot and REST API development, focusing on building real-world backend applications.
