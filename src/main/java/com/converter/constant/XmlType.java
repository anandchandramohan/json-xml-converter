package com.converter.constant;

/**
 *
 * This enum has the Xml types
 *
 * @author  Anand Chandramohan.
 *
 */
public enum XmlType {
    ARRAY("array"),
    OBJECT("object"),
    BOOLEAN("boolean"),
    STRING("string"),
    NUMBER("number"),
    NULL("null"),
    NAME("name");

    private final String type;

    XmlType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
