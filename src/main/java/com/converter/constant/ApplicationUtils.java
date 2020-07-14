package com.converter.constant;

import com.converter.exception.InvalidParameterException;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.*;

/**
 * This contains various methods for aiding file curation and validations.
 *
 * @author Anand Chandramohan.
 *
 */
public class ApplicationUtils {

    /**
     *
     * This method validated the input files in all ways.
     *
     * @param path
     *      The input file path.
     * @throws IOException
     *      It throws when there is I/O issue.
     * @throws InvalidParameterException
     *      It throws when there is a invalid inputs.
     *
     */
    public static void validateInputFilePathAndContent(Path path) throws IOException, InvalidParameterException {
        if(Files.notExists(path)) {
            throw new InvalidParameterException(ErrorMessages.FILE_NOT_EXISTS);
        }
        if(!Files.isRegularFile(path)) {
            throw new InvalidParameterException(ErrorMessages.IS_NOT_A_REGULAR_FILE);
        }
        if(!Files.isReadable(path)) {
            throw new InvalidParameterException(ErrorMessages.FILE_HAS_NO_READ_PERMISSION);
        }
        if(Files.size(path) <= 0) {
            throw new InvalidParameterException(ErrorMessages.FILE_IS_EMPTY);
        }
        if(!FilenameUtils.isExtension(path.toString(), "json")){
            throw new InvalidParameterException(ErrorMessages.NOT_A_VALID_JSON_FILE);
        }
    }

    /**
     *
     * @param path the xml output file path
     * @param fileName the json input file name
     * @return
     * @throws IOException
     * @throws InvalidParameterException
     */
    public static Path curateOutputFilePath(Path path, String fileName) throws IOException, InvalidParameterException {
        String filePath = FilenameUtils.getName(path.toString());
        if(!"".equals(FilenameUtils.getExtension(filePath))) {
            if(!FilenameUtils.isExtension(filePath, "xml")) {
                throw new InvalidParameterException(ErrorMessages.NOT_A_VALID_XML_FILE);
            }
            String name = FilenameUtils.getName(filePath);
            int nameCount = path.getNameCount();
            if(nameCount > 1) {
                Path subpath = path.subpath(0, nameCount - 2);
                Files.createDirectories(subpath);
                path = Paths.get(subpath.toString(), name);
            }
        } else {
            if(Files.notExists(path)) {
                Files.createDirectories(path);
            }
            String outputFileName = FilenameUtils.getBaseName(fileName) + ".xml";
            path = Paths.get(path.toString(), outputFileName);
        }
        return path;
    }
}
