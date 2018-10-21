package me.yekki.weather.service.impl;


import me.yekki.weather.exceptions.LoadCityDataException;
import me.yekki.weather.service.CityDataService;
import me.yekki.weather.utils.XmlBuilder;
import me.yekki.weather.vo.City;
import me.yekki.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> cities() throws LoadCityDataException {
        Resource resource = (Resource) new ClassPathResource("city_list.xml");
        StringBuffer buffer = new StringBuffer();
        String line = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"))
        ) {

            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

            CityList cityList = (CityList) XmlBuilder.xml2obj(CityList.class, buffer.toString());

            return cityList.getCityList();
        }
        catch ( Exception e) {

            throw new LoadCityDataException(e.getMessage());
        }
    }
}
