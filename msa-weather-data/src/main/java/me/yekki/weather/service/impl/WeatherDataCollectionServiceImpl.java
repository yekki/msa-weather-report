package me.yekki.weather.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.yekki.weather.common.Constants;
import me.yekki.weather.service.WeatherDataCollectionService;
import me.yekki.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void syncDataByCity(City city) {
        syncDataByUrl(Constants.weatherURIByCityId(city.getCityId()));
        syncDataByUrl(Constants.weatherURIByCityName(city.getCityName()));
    }


    public void syncDataByUrl(String url) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
        int status = respString.getStatusCodeValue();

        if (status == 200) {
            String strBody = respString.getBody();
            ops.set(url, strBody);
        } else {
            log.error(String.format("Failed to fetch data. http status code: %d", status));
        }
    }
}
