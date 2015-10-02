package org.jemco.contractorportal.invoice;

import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtils {

	public static void marshallToXml(String zpackage, Writer writer, Object data) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance( zpackage );
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		   
		    m.marshal(data, writer);

		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
