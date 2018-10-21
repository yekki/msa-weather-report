package me.yekki.weather.vo;

import lombok.Data;

@Data
public class WeatherResponse {
    private Weather data;
    private Integer status;
    private String desc;
}
