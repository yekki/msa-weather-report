package me.yekki.weather.vo;

import lombok.Data;

import java.util.List;

@Data
public class Weather {
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yeaterday yesterday;
    private List<Forecast> forecast;
}
