package com.example.demo.controller;

import com.example.demo.domain.CurrentWeather;
import com.example.demo.service.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WeatherController {

    private CurrentWeatherService currentWeatherService;

    @Autowired
    public WeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<CurrentWeather> weathers = currentWeatherService.findAll();
        model.addAttribute("weathers", weathers);
        return "weather";
    }
}
