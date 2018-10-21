package me.yekki.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.yekki.weather.common.Constants;
import me.yekki.weather.service.WeatherDataService;
import me.yekki.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {


        return this.getWeahter(Constants.weatherURIByCityId(cityId));
    }

    private WeatherResponse getWeahter(String uri) {

        String strBody = null;
        WeatherResponse resp = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(uri)) {
            strBody = ops.get(uri);
        } else {
            throw new RuntimeException("No data in redis cache.");
        }


        try {
            resp = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("Failed to parse data. Error:" + e.getMessage());
        }

        return resp;
    }
}
