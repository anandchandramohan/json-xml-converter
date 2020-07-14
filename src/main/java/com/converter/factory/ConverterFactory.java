package com.converter.factory;

import com.converter.service.XMLJSONConverter;
import com.converter.service.impl.JsonToXmlConverter;

/**
 *
 * The factory class which gives the converter instance
 *
 * @author  Anand Chandramohan.
 *
 */
public class ConverterFactory {
    public static XMLJSONConverter getConverter() {
        return new JsonToXmlConverter();
    }
}
