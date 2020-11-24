package com.example.demo.repository;

import com.example.demo.domain.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather, Long> {
}
