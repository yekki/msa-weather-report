package me.yekki.weather.service;

import me.yekki.weather.vo.City;

public interface WeatherDataCollectionService {

      void syncDataByCity(City city);
}
