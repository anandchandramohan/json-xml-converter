# JSON to XML converter

This JSON to XML converter is the java library which wil creates xml file based on JSON file.

## Prerequisites

   1. Java 7
   2. Maven 3.6.1

## To get started

   - Enter the extracted folder into csw/.
   - To run unit test cases, please run the below maven command [optional]

	`mvn test`

   - To build the application - please run the below maven command,

	`mvn clean install`

   - The build command creates a csw.jar file inside target folder.
   - To run the application, please run the command below,

	`java -jar csw.jar [input_file_json_path] [output_file_xml_path]`

   - The application will create xml file mentioned in the <output_file_xml_path>

## Usage

To run the jar file needs two input arguments

   1. Argument 1 - The file path must be valid with .xml file extension.
   2. Argument 2 - The file path may or may not exist but if path has file name with extension then it must be with .xml file extension

## Examples

   - This will create xml file in the current directory named as "output_xml_file.xml"

	`java -jar csw.jar input_json_file.json output_xml_file.xml`

   - This will create xml file in the current directory named as "json_file.xml" (Which uses the same file name from argument 1 with .xml extension)

	`java -jar csw.jar json_file.json .`

   - This will create xml file inside ./output/json_flie.xml (Which will create all the directories if not exist and create a xml file)

	`java -jar csw.jar json_file.json ./output/`

## Libraries 

1. JUnit (Unit test) - https://mvnrepository.com/artifact/junit/junit
2. Json parser and xml stream writer - https://mvnrepository.com/artifact/javax.json/javax.json-api
3. Json parser and xml stream writer implementaion - https://mvnrepository.com/artifact/org.glassfish/javax.json
4. IO utility - https://mvnrepository.com/artifact/commons-io/commons-io
5. XML file utility for unit test - https://mvnrepository.com/artifact/xmlunit/xmlunit
	

## Unit Test

Please refer the Unit test case file inside src/test/ directory.


