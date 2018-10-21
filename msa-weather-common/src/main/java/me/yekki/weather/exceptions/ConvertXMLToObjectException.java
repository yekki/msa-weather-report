package me.yekki.weather.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ConvertXMLToObjectException extends Exception {

    public ConvertXMLToObjectException() {
        super();
    }

    public ConvertXMLToObjectException(String message) {
        super(message);
    }
}
