package me.yekki.weather.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.yekki.weather.service.WeatherDataService;
import me.yekki.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    //Test data: 101280601
    @ApiOperation(value = "根据城市ID查询天气", notes = "查询某城市的天气情况")
    @ApiImplicitParam(name = "id", value = "城市ID(例如：101280601)", paramType = "path", required = true, dataType = "String")
    @GetMapping("/city/{id}")
    public WeatherResponse getWeatherByCityId(@PathVariable("id") String cityId) {

        return weatherDataService.getDataByCityId(cityId);
    }

    @ApiOperation(value = "重定向到Swagger2 API控制台", notes = "Swagger API控制台")
    @GetMapping(value = "/")
    public void home(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui.html");
    }
}
