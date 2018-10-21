package me.yekki.weather.exceptions;

public class LoadCityDataException extends Exception {
    public LoadCityDataException() {
        super();
    }

    public LoadCityDataException(String message) {
        super(message);
    }
}
