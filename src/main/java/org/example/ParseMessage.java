package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class ParseMessage {

    private static final Logger LOG = LoggerFactory.getLogger(ParseMessage.class);

    public void apply(String xml) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new InputSource(new StringReader(xml)), new MyXMLHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
