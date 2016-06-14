package com.example.switchyard.switchyard_soap_demo;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public final class PersonLocatorTransformer {

	@Transformer(to = "{urn:com.example.switchyard:switchyard-soap-demo:1.0}findByLastNameResponse")
	public Element transformListToFindByLastNameResponse(List<Person> from) {
		
		List<Person> result = (List<Person>) from;
		StringBuffer bodyXml = new StringBuffer();
		for (Person p : result) {
			bodyXml
			.append("<Person>")
			.append("<FirstName>" + p.getFirstName() + "</FirstName>")
			.append("<LastName>" + p.getLastName() + "</LastName>")
			.append("<age>" + p.getAge() + "</age>")
			.append("</Person>");
		}

		StringBuffer ackXml = new StringBuffer()
		.append("<findByLastNameResponse xmlns:orders=\"urn:com.example.switchyard:switchyard-soap-demo:1.0\">")
		.append("<Persons>")
		.append(bodyXml)
		.append("</Persons>")
		.append("</findByLastNameResponse>");

		return toElement(ackXml.toString());
	}

	@Transformer(from = "{urn:com.example.switchyard:switchyard-soap-demo:1.0}findByLastName")
	public String transformFindByLastNameToString(Element from) {
		String value = from.getTextContent();
		System.out.println(value);
		return value;
	}
	
    
    private Element toElement(String xml) {
        DOMResult dom = new DOMResult();
        try {
            TransformerFactory.newInstance().newTransformer().transform(
                    new StreamSource(new StringReader(xml)), dom);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return ((Document)dom.getNode()).getDocumentElement();
    }
}
