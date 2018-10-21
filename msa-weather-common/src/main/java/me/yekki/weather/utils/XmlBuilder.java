package me.yekki.weather.utils;

import me.yekki.weather.exceptions.ConvertXMLToObjectException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    public static Object xml2obj(Class<?> clazz, String xml) throws ConvertXMLToObjectException {

        Object obj = null;

        try ( Reader reader = new StringReader(xml)){
            JAXBContext context = JAXBContext.newInstance(clazz);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            obj = unmarshaller.unmarshal(reader);
        }
        catch( Exception e) {

            throw new ConvertXMLToObjectException(e.getMessage());
        }

        return obj;
    }
}
