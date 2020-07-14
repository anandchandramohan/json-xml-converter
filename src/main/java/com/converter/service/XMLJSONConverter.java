package com.converter.service;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The interface which has the XML and JSON converter behaviours
 *
 * @author  Anand Chandramohan.
 */
public interface XMLJSONConverter {
    void convertJSONtoXML(Path jsonFilePath, Path xmlFilePath) throws IOException, XMLStreamException;
}
