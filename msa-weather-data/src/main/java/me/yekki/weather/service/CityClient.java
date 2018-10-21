package me.yekki.weather.service;

import me.yekki.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city")
@Service
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}

