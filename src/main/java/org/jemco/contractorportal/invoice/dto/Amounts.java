package org.jemco.contractorportal.invoice.dto;

import javax.xml.bind.annotation.XmlElement;

public class Amounts {

	private String currency;
	private Double totalWithoutVat;
	private Double totalWithVat;
	
	@XmlElement(name="currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@XmlElement(name="totalprice")
	public Double getTotalWithoutVat() {
		return totalWithoutVat;
	}
	public void setTotalWithoutVat(Double totalWithoutVat) {
		this.totalWithoutVat = totalWithoutVat;
	}
	@XmlElement(name="totalwithvat")
	public Double getTotalWithVat() {
		return totalWithVat;
	}
	public void setTotalWithVat(Double totalWithVat) {
		this.totalWithVat = totalWithVat;
	}
	
	
}
