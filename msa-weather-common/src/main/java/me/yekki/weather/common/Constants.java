package me.yekki.weather.common;

public final class Constants {
    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    public static final int UPDATE_TIME_INTERVAL = 1800;
    public static String weatherURIByCityId(String cityId) {
        return WEATHER_URI + "citykey=" + cityId;
    }
    public static String weatherURIByCityName(String cityId) {
        return WEATHER_URI + "city=" + cityId;
    }
}
