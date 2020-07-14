package com.converter.service.impl;

import com.converter.constant.XmlType;
import com.converter.service.XMLJSONConverter;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * The JSON to XML converter.
 *
 * @author  Anand Chandramohan.
 *
 */
public class JsonToXmlConverter implements XMLJSONConverter {

    private static final XMLOutputFactory XML_OUTPUT_FACTORY = XMLOutputFactory.newInstance();

    /**
     *
     *This reads JSON file and create as a XML file.
     *
     * @param jsonFilePath the input JSON file path
     * @param xmlFilePath the output XML file path
     * @throws IOException
     * @throws XMLStreamException
     *
     */
    @Override
    public void convertJSONtoXML(Path jsonFilePath, Path xmlFilePath) throws IOException, XMLStreamException {
        BufferedReader reader = Files.newBufferedReader(jsonFilePath);
        BufferedWriter writer = Files.newBufferedWriter(xmlFilePath, StandardCharsets.UTF_8);
        JsonParser parser = Json.createParser(reader);
        XMLStreamWriter xmlStreamWriter = XML_OUTPUT_FACTORY.createXMLStreamWriter(writer);
        convert(parser, xmlStreamWriter);
        System.out.println("Successfully created XML file from the given JSON file");
        System.out.println("Please refer to the newly created XML file: "+ xmlFilePath.toString());
    }

    /**
     *
     * This orchestrate to write XML file from JSON.
     *
     * @param parser the json parser
     * @param writer the XML stream writer
     * @throws XMLStreamException
     *
     */
    private void convert(JsonParser parser, XMLStreamWriter writer) throws XMLStreamException {
        writeAsXml(parser, writer);
        writer.writeEndDocument();
        writer.flush();
        parser.close();
    }

    /**
     *
     * Use parser and writer to parse the input JSON and write into XML file.
     *
     * @param parser the json parser
     * @param writer the XML Stream writer
     * @throws XMLStreamException
     *
     */
    private void writeAsXml(JsonParser parser, XMLStreamWriter writer) throws XMLStreamException
    {
        String keyName = null;
        while (parser.hasNext())
        {
            JsonParser.Event event = parser.next();

            switch(event)
            {
                case START_ARRAY:
                    writer.writeStartElement(XmlType.ARRAY.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    break;
                case END_ARRAY:
                    writer.writeEndElement();
                    break;
                case START_OBJECT:
                    writer.writeStartElement(XmlType.OBJECT.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    break;
                case END_OBJECT:
                    writer.writeEndElement();
                    break;
                case VALUE_FALSE:
                    writer.writeStartElement(XmlType.BOOLEAN.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    writer.writeCharacters("false");
                    writer.writeEndElement();
                    break;
                case VALUE_TRUE:
                    writer.writeStartElement(XmlType.BOOLEAN.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    writer.writeCharacters("true");
                    writer.writeEndElement();
                    break;
                case KEY_NAME:
                    keyName = parser.getString();
                    break;
                case VALUE_STRING:
                    writer.writeStartElement(XmlType.STRING.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    writer.writeCharacters(parser.getString());
                    writer.writeEndElement();
                    break;
                case VALUE_NUMBER:
                    writer.writeStartElement(XmlType.NUMBER.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    writer.writeCharacters(parser.getString());
                    writer.writeEndElement();
                    break;
                case VALUE_NULL:
                    writer.writeEmptyElement( XmlType.NULL.getType());
                    keyName = writeAttributeIfExist(writer, keyName);
                    break;
            }

            writer.flush();
        }
    }

    /**
     *
     * Add attribute in the xml element if present.
     *
     * @param writer the XML Stream writer
     * @param keyName the attribute
     * @return
     * @throws XMLStreamException
     *
     */
    private String writeAttributeIfExist(XMLStreamWriter writer, String keyName) throws XMLStreamException {
        if (keyName != null) {
            writer.writeAttribute(XmlType.NAME.getType(), keyName);
            keyName = null;
        }
        return keyName;
    }

}