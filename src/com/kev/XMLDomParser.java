package com.kev;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLDomParser {

    public static List<Item> parseXML(String filename) {

        List<Item> items = new ArrayList<>();

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("item");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    int id = Integer.parseInt(element.getAttribute("id"));

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    int quantity = Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent());
                    int vendorBuysFor = Integer.parseInt(element.getElementsByTagName("vendorBuysFor").item(0).getTextContent());
                    int level = Integer.parseInt(element.getElementsByTagName("level").item(0).getTextContent());

                    items.add(new Item(id, name, quantity, vendorBuysFor, level));

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}
