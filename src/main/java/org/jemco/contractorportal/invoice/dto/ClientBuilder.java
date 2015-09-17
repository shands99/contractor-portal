package org.jemco.contractorportal.invoice.dto;

public class ClientBuilder {

	private ClientType client = new ClientType();
	
	public ClientBuilder addCompanyName(String value) {
		this.client.setCompany(value);
		return this;
	}

	public ClientType getClient() {
		return client;
	}
	
}
