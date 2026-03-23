# Lottery API – Spring Boot, CSV Ingestion, and Analytics

A backend application built with Spring Boot that ingests historical lottery data from a CSV file, stores it in an H2 database, and exposes RESTful API endpoints to query lottery draws. Designed to demonstrate backend engineering skills, data ingestion pipelines, and API development in a professional, testable way.

## Key Features:

- CSV ingestion pipeline directly from resources/data/lottery.csv
- H2 in-memory database for fast, local testing
- REST endpoints for retrieving lottery draws and statistics
- Clean, modular service, repository, and controller layers
- Easily extensible for analytics or integration with dashboards

## Tech Stack:

- Java 17 + Spring Boot 4.x
- Spring Data JPA / H2 Database
- REST API
- Maven build and dependency management

## Purpose:
Showcases ability to design production-ready APIs, and handle data ingestion.

## Project Structure
```
lottery-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── me/theoria/lottery_api/
│   │   │       ├── controller/
│   │   │       │   ├── LotteryController.java
│   │   │       │   └── LotteryCSVController.java
│   │   │       ├── model/
│   │   │       │   └── LotteryDraw.java
│   │   │       ├── repository/
│   │   │       │   └── LotteryRepository.java
│   │   │       └── service/
│   │   │           ├── LotteryService.java
│   │   │           └── LotteryCSVService.java
│   │   └── resources/
│   │       ├── data/
│   │       │   └── lottery.csv
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── me/theoria/lottery_api/
│               └── LotteryApiTests.java
├── .gitignore
├── pom.xml
└── README.md
```

## Endpoints
- `GET /api/lottery/draws` — fetch all draws
- `GET /api/lottery/stats/numbers?topN=10` - Top N Numbers (N=x)

## How to Run
Clone the repo:
   ```bash
   git clone https://github.com/quantum-yeti/lottery-api.git
   ```

Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

Access API at http://localhost:8080

## Notes
- CSV file is in src/main/resources/data/lottery.csv
- API uses JPA/H2 for persistence