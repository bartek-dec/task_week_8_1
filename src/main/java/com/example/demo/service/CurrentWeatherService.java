package com.example.demo.service;

import com.example.demo.domain.CurrentWeather;

import java.util.List;

public interface CurrentWeatherService {

    List<CurrentWeather> findAll();
}
