package com.converter;

import com.converter.exception.InvalidParameterException;
import com.converter.factory.ConverterFactory;
import com.converter.service.XMLJSONConverter;
import com.converter.constant.ApplicationUtils;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Starting point of this application
 *
 * @author Anand Chandramohan
 *
 */
public class Application {

    /**
     *
     * This is the starting point of the Application which receives two files path arguments, process JSON and writes as XML
     *
     * @param args the arguments
     *
     */
    public static void main(String[] args)  {
        if(args.length != 2) {
            printUsage();
            System.exit(1);
        }
        String jsonPath = args[0];
        String xmlPath = args[1];

        Path inputJsonPath = Paths.get(jsonPath);
        Path outputXmlPath = Paths.get(xmlPath);
        try {
            ApplicationUtils.validateInputFilePathAndContent(inputJsonPath);
            String inputFileName = inputJsonPath.getFileName().toString();
            outputXmlPath = ApplicationUtils.curateOutputFilePath(outputXmlPath, inputFileName);
            XMLJSONConverter converter =  ConverterFactory.getConverter();
            converter.convertJSONtoXML(inputJsonPath, outputXmlPath);
        } catch (InvalidParameterException | IOException | XMLStreamException e) {
            System.out.println("ERROR: "+ e.getMessage());
            printUsage();
            System.exit(1);
        }
    }

    /**
     *
     * This print the usage message
     *
     */
    public static void printUsage() {
        System.out.println("Usage: Expecting two inputs file path");
        System.out.println("<First Argument> - The file path must be valid with .xml file extension.");
        System.out.println("<Second Argument> - The file path may or may not exist but if path has file name with extension then it must be with .xml file extension.");
        System.out.println("Examples:");
        System.out.println("java -jar csw.jar input_json_file.json output_xml_file.xml");
        System.out.println("java -jar csw.jar json_file.json .");
        System.out.println("java -jar csw.jar json_file.json ./output/");
        System.out.println("java -jar csw.jar json_file.json ./output/json_file.xml");
    }

}

