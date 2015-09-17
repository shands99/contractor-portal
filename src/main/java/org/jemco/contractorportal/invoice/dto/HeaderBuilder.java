package org.jemco.contractorportal.invoice.dto;

import java.util.Date;

public class HeaderBuilder {

	private Header header = new Header();
	
	public HeaderBuilder addInvoiceNumber(String value) {
		header.setInvoicenr(value);
		return this;
	}
	
	public HeaderBuilder addInvoiceDate(Date value) {
		header.setInvoicedate(DtoUtils.convertToXmlDate(value));
		return this;
	}
	
	public HeaderBuilder addInvoiceDue(Date value) {
		header.setDue(DtoUtils.convertToXmlDate(value));
		return this;
	}

	public Header getHeader() {
		return header;
	}
	
}
