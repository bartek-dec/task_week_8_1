package com.example.demo.service;

import com.example.demo.api.WeatherApi;
import com.example.demo.domain.CurrentWeather;
import com.example.demo.domain.api.WeatherForecast;
import com.example.demo.repository.CurrentWeatherRepository;
import com.example.demo.util.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private CurrentWeatherRepository repository;
    private WeatherMapper weatherMapper;
    private WeatherApi weatherApi;

    @Autowired
    public CurrentWeatherServiceImpl(CurrentWeatherRepository repository,
                                     WeatherMapper weatherMapper,
                                     WeatherApi weatherApi) {
        this.repository = repository;
        this.weatherMapper = weatherMapper;
        this.weatherApi = weatherApi;
    }

    @Scheduled(fixedDelay = 600000)
    private void save() {
        WeatherForecast weatherForecast = weatherApi.getWeatherForecast();
        if (weatherForecast != null) {
            repository.save(weatherMapper.getCurrentWeather(weatherForecast));
        }
    }

    @Override
    public List<CurrentWeather> findAll() {
        return repository.findAll();
    }
}
