package me.yekki.weather.service;

import me.yekki.weather.vo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);
}
