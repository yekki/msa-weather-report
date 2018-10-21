package me.yekki.weather.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

//    @Autowired
//    private WeatherReportService weatherReportService;

   // @Autowired
   // private CityClient cityClient;

//    @GetMapping("/city/{id}")
//    public ModelAndView getReportByCityId(@PathVariable("cityId") String id, Model model) throws Exception {
//
//        List<City> cityList = null;
//        try {
//            cityList = cityClient.listCity();
//        } catch(Exception e) {
//
//            log.error("Failed to get city list, error: " + e.getMessage());
//        }
//
//        model.addAttribute("title", "天气预报");
//        model.addAttribute("cityId", id);
//        model.addAttribute("cityList", cityList);
//        model.addAttribute("report", weatherReportService.getDataByCityId(id));
//
//        return new ModelAndView("weather/report", "reportModel", model);
//    }
}
