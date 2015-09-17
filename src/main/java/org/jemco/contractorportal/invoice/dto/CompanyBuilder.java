package org.jemco.contractorportal.invoice.dto;

import org.jemco.contractorportal.contractor.dto.Company;

public class CompanyBuilder {

	private Company company = new Company();
	
	public CompanyBuilder addAccount(String value) {
		this.company.setAccount(value);
		return this;
	}
	
	public CompanyBuilder addSortcode(String value) {
		this.company.setSortcode(value);
		return this;
	}
	
	public CompanyBuilder addCompanyName(String value) {
		this.company.setCompanyname(value);
		return this;
	}
	
	public CompanyBuilder addRegNo(String value) {
		this.company.setRegistration(value);
		return this;
	}
	
	public CompanyBuilder addVatNo(String value) {
		this.company.setVatno(value);
		return this;
	}

	public Company getCompany() {
		return company;
	}
	
}
