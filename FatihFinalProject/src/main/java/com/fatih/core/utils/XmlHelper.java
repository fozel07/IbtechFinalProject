package com.fatih.core.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlHelper {
	// Single
		// Lazy-Initialization
		private static DocumentBuilderFactory factory;
		public static DocumentBuilderFactory getFactory() {
			if(factory==null) {
				factory= DocumentBuilderFactory.newInstance();
			}
			return factory;
			
		}
		public static Document parse(InputStream in) throws ParserConfigurationException, SAXException, IOException{
			DocumentBuilder builder = getFactory().newDocumentBuilder();
			Document document = builder.parse(in);
			return document;
		}
		public static String getSingleElementText(Element parent, String tag , String defaultValue) {
			NodeList elementList=parent.getElementsByTagName(tag);
			if(elementList.getLength()==0) {
				return defaultValue;
			}
		return parent.getElementsByTagName(tag).item(0).getTextContent();
		
		}
		public static double getSingleElementText(Element parent, String tag , double defaultValue) {
			String  string=getSingleElementText(parent, tag, Double.toString(defaultValue));
		return Double.parseDouble(string);
		}
		public static long getSingleElementText(Element parent, String tag , long defaultValue) {
			String  string=getSingleElementText(parent, tag, Double.toString(defaultValue));
		return Long.parseLong(string);
		}
		public static String getAttribute(Element element, String name , String defaultValue) {
			if(!element.hasAttribute(name)) {
				return defaultValue;
			}
			return element.getAttribute(name);
			
		}
		public static long getAttribute(Element element, String name , long defaultValue) {
		String string= getAttribute(element, name, Long.toString(defaultValue));
		return Long.parseLong(string);
			
		}
		public static Document create(String root) throws ParserConfigurationException {
			DocumentBuilder builder=getFactory().newDocumentBuilder();
			Document document=builder.newDocument();
			Element employee = document.createElement(root);
			document.appendChild(employee);
			return document;
		}
		
		
		public static Element addSingleElementText(Document document, Element parent, String tag, String content) {
			Element element = document.createElement(tag);
			element.setTextContent(content);
			return (Element) parent.appendChild(element);

		}

		public static Element addSingleElementText(Document document, Element parent, String tag, double content) {
			String string = Double.toString(content);
			return addSingleElementText(document, parent, tag, string);
		}

		public static Element addSingleElementText(Document document, Element parent, String tag, long content) {
			String string = Long.toString(content);
			return addSingleElementText(document, parent, tag, string);
		}
		public static void dump(Document document,OutputStream out) throws IOException, TransformerException {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			DOMSource data = new DOMSource(document);
			StreamResult result = new StreamResult(out);
			transformer.transform(data, result);
			out.close();
		}
		
		

}
