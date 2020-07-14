package com.converter.service.impl;

import com.converter.factory.ConverterFactory;
import com.converter.service.XMLJSONConverter;
import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class JsonToXmlConverterTest {

    private final XMLJSONConverter converter = ConverterFactory.getConverter();

    private final static String TEST_RESOURCES_BASE_PATH = "src/test/resources/";

    private final static String ACTUAL_FOLDER = "actual";

    @Before
    public void before() throws IOException {
        Files.createDirectories(Paths.get(TEST_RESOURCES_BASE_PATH, ACTUAL_FOLDER));
        XMLUnit.setIgnoreWhitespace(true);
    }

    @Test
    public void testNumberOnyConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"number_only.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "number_only.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "number_only.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testObjectWithNumberConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"object_with_numbers.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "object_with_numbers.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "object_with_numbers.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testStringOnyConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"string_only.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "string_only.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "string_only.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testObjectWithStringConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"object_with_string.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "object_with_string.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "object_with_string.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testBooleanOnyConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"boolean_only.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "boolean_only.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "boolean_only.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testObjectWithBooleanConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"object_with_boolean.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "object_with_boolean.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "object_with_boolean.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testNullOnyConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"null_only.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "null_only.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "null_only.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testArrayConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"array_only_with_number_string_boolean.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "array_only_with_number_string_boolean.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "array_only_with_number_string_boolean.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @Test
    public void testNestedConvertJSONtoXML() throws IOException, XMLStreamException, SAXException {
        Path jsonInput = Paths.get(TEST_RESOURCES_BASE_PATH,"nested.json");
        Path jsonInputActualPath = Paths.get(TEST_RESOURCES_BASE_PATH,ACTUAL_FOLDER, "nested.xml");
        Path expectedXmlPath = Paths.get(TEST_RESOURCES_BASE_PATH, "nested.xml");
        converter.convertJSONtoXML(jsonInput, jsonInputActualPath);
        BufferedReader actual = Files.newBufferedReader(jsonInputActualPath);
        BufferedReader expected = Files.newBufferedReader(expectedXmlPath);
        Diff diff = XMLUnit.compareXML(actual, expected);
        assertTrue(diff.identical());
    }

    @After
    public void after() throws IOException {
        File file = FileUtils.getFile(TEST_RESOURCES_BASE_PATH, ACTUAL_FOLDER);
        FileUtils.deleteDirectory(file);
    }
}