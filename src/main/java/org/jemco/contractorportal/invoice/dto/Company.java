package org.jemco.contractorportal.invoice.dto;

import javax.xml.bind.annotation.XmlElement;

public class Company {

	private String account;
	private String sortCode;
	private String companyName;
	private String address1;
	private String address2;
	private String addressCity;
	private Long registrationNumber;
	private Long vatNumber;
	
	@XmlElement(name = "account")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	@XmlElement(name = "sortcode")
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	@XmlElement(name = "companyname")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@XmlElement(name = "address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@XmlElement(name = "address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@XmlElement(name = "city")
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	@XmlElement(name = "registration")
	public Long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	@XmlElement(name = "vatno")
	public Long getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(Long vatNumber) {
		this.vatNumber = vatNumber;
	}
	
}
