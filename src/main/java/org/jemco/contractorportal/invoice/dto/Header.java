package org.jemco.contractorportal.invoice.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Header {

	private Long invoiceNumber;
	private Date invoiceDate;
	private Date due;
	private Client client;
	private Company company;
	
	@XmlElement(name = "invoicenr")
	public Long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	@XmlElement(name = "invoicendate")
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	@XmlElement(name = "due")
	public Date getDue() {
		return due;
	}
	public void setDue(Date due) {
		this.due = due;
	}
	@XmlElement(name = "client")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@XmlElement(name = "company")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
