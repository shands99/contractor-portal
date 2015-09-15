package org.jemco.contractorportal.invoice.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="invoice")
public class Invoice {
	
	private Header invoiceHeader;
	private Amounts invoiceAmounts;
	private List<Item> invoiceItems;

	@XmlElement(name = "header")
	public Header getInvoiceHeader() {
		return invoiceHeader;
	}
	public void setInvoiceHeader(Header invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}
	
	@XmlElement(name = "amounts")
	public Amounts getInvoiceAmounts() {
		return invoiceAmounts;
	}
	public void setInvoiceAmounts(Amounts invoiceAmounts) {
		this.invoiceAmounts = invoiceAmounts;
	}
	
	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<Item> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<Item> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
	
	
	
}
