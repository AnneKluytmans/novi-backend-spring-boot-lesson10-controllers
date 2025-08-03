# Spring Boot REST Controllers – NOVI Backend Assignment

## About the Project

This repository contains a basic Spring Boot application used to practice creating and handling **RESTFUL controllers** as part of the Backend module at [Novi University](https://www.novi.nl).

The project features two main controllers:

- `GreetingController`: returns simple greeting messages.
- `WeatherController`: returns weather data, including support for path variables and query parameters.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Endpoints](#endpoints)
- [How to Run](#how-to-run)
- [Credits](#credits)
- [License](#license)

---

## Tech Stack

- **IntelliJ IDEA** (recommended IDE)
- **Java 17+**
- **Spring Boot 3.x**
- **Maven**
- **Spring Web (REST API)**

---

## Features

### GreetingController
- Returns a static greeting (`Hello World!`)
- Returns a personalized greeting based on the user's name via path variable

### WeatherController
- Returns a generic weather message
- Returns city-based weather using a path variable
- Returns coordinate-based weather using query parameters
- Includes validation for query parameters (e.g. valid latitude/longitude ranges)

---

## Endpoints

### GreetingController

| Method | Endpoint                    | Description                             |
|--------|-----------------------------|-----------------------------------------|
| GET    | `/api/greeting`             | Returns a simple "Hello World!" message |
| GET    | `/api/greeting/{name}`      | Returns a personalized greeting         |

Example:  
`GET` http://localhost:8080/api/greeting/John
→ "Hello John! Nice to see you!"

---

### WeatherController

| Method | Endpoint                                | Description                                            |
|--------|-----------------------------------------|--------------------------------------------------------|
| GET    | `/api/weather/current`                  | Returns a general weather description                  |
| GET    | `/api/weather/current/{city}`           | Returns city-specific weather if available             |
| GET    | `/api/weather/current/coordinates`      | Returns weather info based on latitude & longitude     |

Example (coordinates):  
`GET` http://localhost:8080/api/weather/current/coordinates?lat=52.37&lon=4.89
→ "Current weather for coordinates lat: 52.37 and lon: 4.89 is: Cloudy with a gentle breeze."

Example (city not found):  
`GET` http://localhost:8080/api/weather/current/Atlantis
→ "Atlantis not recognized. General forecast for the Netherlands: Cloudy with patches of sunshine, and a chance of light rain."

---

## How to Run

1. Clone the repository:
   ```bash
    git@github.com:AnneKluytmans/novi-backend-springboot-controllers.git
    ```
   or
    ```bash
    git clone https://github.com/AnneKluytmans/novi-backend-springboot-controllers.git 
    ```
2. Open the project in your IDE (IntelliJ IDEA)

3. Navigate to the `DemoApplication` class
4. Run the application → click the green play button or use the terminal:
    ```bash
    ./mvnw spring-boot:run
    ```
5. Access the API using Postman or your browser: http://localhost:8080/api/greeting


## Credits
> "This assignment was developed as part of the Backend Java module in the NOVI Software Development program. All instructions, logic, and structure are part of the official coursework."

## License
> "This repository is intended for educational purposes only. You are welcome to use the code for learning, but not for commercial use."