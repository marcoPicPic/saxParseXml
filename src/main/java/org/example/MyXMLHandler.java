package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandler extends DefaultHandler {

    boolean element = false;

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        //System.out.println("Start Element :" + qName);
        if (qName.equalsIgnoreCase("ns4:TypeCode")) {
            System.out.println("Start Element :" + qName);
            element = true;
        }
    }
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        //System.out.println("End Element :" + qName);

    }
    public void characters(char ch[], int start, int length) throws SAXException {

        if (element) {
            System.out.println("TypeCode  : " + new String(ch, start, length));
            element = false;
        }

    }
}
