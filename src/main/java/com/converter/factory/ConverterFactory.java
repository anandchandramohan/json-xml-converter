package com.converter.factory;

import com.converter.service.XMLJSONConverter;
import com.converter.service.XMLJSONConverterImpl;

/**
 *
 * The factory class which gives the converter instance
 *
 * @author  Anand Chandramohan.
 *
 */
public class ConverterFactory {

    /**
     * The factory class which create converter
     *
     * @return
     *
     */
    public static XMLJSONConverter getConverter() {

        // In future, we need to change here when we add more implementation provider
        return new XMLJSONConverterImpl();
    }
}
