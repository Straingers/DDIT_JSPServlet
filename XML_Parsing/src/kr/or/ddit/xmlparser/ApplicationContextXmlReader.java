package kr.or.ddit.xmlparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ApplicationContextXmlReader {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xml = new File("application-context.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.parse(xml);
		
		Element element = document.getDocumentElement();
		
		NodeList list = element.getChildNodes();
		
		for(int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;
				String id = ele.getAttribute("id");
				String klass = ele.getAttribute("class");
				String name = "";
				String refValue = "";
				
				System.out.println("'id'=" + id + " / 'class'=" + klass);
				
				if(ele.getElementsByTagName("property").getLength() > 0) {
					NodeList listChild = ele.getChildNodes();
					for(int j = 0; j < listChild.getLength(); j++) {
						Node nodeChild = listChild.item(j);
						if(nodeChild.getNodeType() == Node.ELEMENT_NODE) {
							Element eleChild = (Element) nodeChild;
							name = eleChild.getAttribute("name");
							refValue = eleChild.getAttribute("ref-value"); 
							System.out.println("'" + id + "' : " + "'name'=" + name + " / 'ref-value'=" + refValue);
						}
					}
				}
			}
		}
	}
	
}

