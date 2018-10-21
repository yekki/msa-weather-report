package me.yekki.weather.controller;

import me.yekki.weather.service.CityClient;
import me.yekki.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public List<City> cities() throws Exception {

        return cityClient.listCity();
    }
}
