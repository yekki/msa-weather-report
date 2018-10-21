package me.yekki.weather.service;

import me.yekki.weather.vo.City;

import java.util.List;

public interface CityDataService {

    List<City> cities() throws Exception;
}
