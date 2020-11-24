package com.example.demo.util;

import com.example.demo.domain.CurrentWeather;
import com.example.demo.domain.api.WeatherForecast;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public CurrentWeather getCurrentWeather(WeatherForecast weatherForecast) {
        CurrentWeather currentWeather = new CurrentWeather();

        currentWeather.setCity(weatherForecast.getLocation().getName());
        currentWeather.setLocalTime(weatherForecast.getLocation().getLocaltime());
        currentWeather.setTemperature(weatherForecast.getCurrent().getTempC());
        currentWeather.setIconUrl(getIconUrl(weatherForecast.getCurrent().getCondition().getIcon()));

        return currentWeather;
    }

    private String getIconUrl(String icon) {
        return icon.substring(29);
    }
}
