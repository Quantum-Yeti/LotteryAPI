# Lottery API

Spring Boot API for ingesting and serving lottery draw data.

## Features
- Upload lottery CSV (`lottery.csv`) via REST endpoint
- View all lottery draws
- H2 in-memory database for fast setup

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