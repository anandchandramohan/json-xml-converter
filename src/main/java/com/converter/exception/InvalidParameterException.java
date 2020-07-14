package com.converter.exception;

/**
 *
 * This class is the general class of exceptions produced by when the function received invalid inputs.
 *
 * @author  Anand Chandramohan.
 *
 */
public class InvalidParameterException extends Exception {

    /**
     *
     * @param message
     *      The detail message of the exception.
     *
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}
