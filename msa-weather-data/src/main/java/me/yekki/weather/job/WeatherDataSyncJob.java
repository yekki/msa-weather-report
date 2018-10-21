package me.yekki.weather.job;

import lombok.extern.slf4j.Slf4j;
import me.yekki.weather.service.CityClient;
import me.yekki.weather.service.WeatherDataCollectionService;
import me.yekki.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("Weather Data Sync Job Started!");

        List<City> cityList = null;

        try {
            cityList = cityClient.listCity();
            cityList.forEach(city->{
                log.info(String.format("Weather Data Sync Job, cityId:%s", city.getCityId()));
                weatherDataCollectionService.syncDataByCity(city);
            });
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info("Weather Data Sync Job. End！");
    }
}
