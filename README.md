# little-weather-app
A RESTful Spring Boot project that shows weather information using the OpenWeather API

# General info
This project is a backend project that has these 2 main operations: 
  Retrieving the weather data of the taken city name through One Call API 2.5. and One Call API 3.0 provided by https://openweathermap.org/
  Provides the weather forecast and, given a city, must provide the following information for the next 48 hours:
      - maximum, feels like temperatures, humidity
  
# Technologies
The project is created with:
* Java version: 17
* Spring Boot Starter Web version: 3.2.2

# Usage
The response of the backend can be obtained by:

  POSTMAN - POST /weather/hourly with Body that has the city name 

![image](https://github.com/goraldilara/little-weather-app/assets/33300564/4c174a1c-743c-47c3-bc7f-af0e2d81a27f)


  
