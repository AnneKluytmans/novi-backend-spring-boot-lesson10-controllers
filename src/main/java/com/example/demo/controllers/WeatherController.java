package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {
    private static final Map<String, String> cityWeatherMap = new HashMap<>();

    static {
        cityWeatherMap.put("amsterdam", "Clear skies with a light breeze. Great day to explore the canals!");
        cityWeatherMap.put("rotterdam", "Overcast with a chance of rain. Perfect for a museum day.");
        cityWeatherMap.put("den haag", "Sunny with a few clouds. Ideal for a stroll along the beach.");
        cityWeatherMap.put("utrecht", "Misty morning turning into a sunny afternoon. Perfect for a canal-side walk.");
        cityWeatherMap.put("eindhoven", "Partly cloudy with a cool breeze. Good day to visit the city center.");
        cityWeatherMap.put("tilburg", "Warm and sunny. Perfect day for a bike ride.");
        cityWeatherMap.put("groningen", "Light rain expected. Don't forget your umbrella!");
        cityWeatherMap.put("almere", "Clear skies with a mild wind. Great day for outdoor activities.");
        cityWeatherMap.put("breda", "Cloudy with occasional sun breaks. A cozy day for a café visit.");
        cityWeatherMap.put("nijmegen", "Crisp and cool with sunshine. Ideal weather for a park walk.");
    }



    @GetMapping("/api/weather/current")
    public String currentWeather() {
        return "Current weather:  A soft drizzle under a misty sky.";
    }

    @GetMapping("/api/weather/current/{city}")
    public ResponseEntity<String> getCurrentWeatherCity(@PathVariable String city) {
        String normalizedCity = city.trim().toLowerCase();
        String weatherDescription = cityWeatherMap.get(normalizedCity);

        if (weatherDescription != null) {
            return ResponseEntity.ok("Current weather in " + city + ": " + weatherDescription);
        } else {
            String defaultWeather = "General forecast for the Netherlands: Cloudy with patches of sunshine, and a chance of light rain.";
            return ResponseEntity.ok(city + " not recognized. \n" + defaultWeather);
        }
    }

    @GetMapping("/api/weather/current/coordinates")
    public ResponseEntity<String> getCurrentWeatherCoordinates(@RequestParam("lat") Double latitude, @RequestParam("lon") Double longitude) {

        if (latitude == null || longitude == null) {
            return ResponseEntity.badRequest().body("Error: Latitude and longitude parameters are required.");
        }

        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            return ResponseEntity.badRequest().body("Error: Latitude must be between -90 and 90, and longitude between -180 and 180.");
        }

        String weatherDescription = "Cloudy with a gentle breeze. ";
        return ResponseEntity.ok("Current weather for coordinates lat: " + latitude + " and lon: " + longitude + " is: " + weatherDescription);
    }

}


