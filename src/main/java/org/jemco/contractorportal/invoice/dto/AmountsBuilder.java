package org.jemco.contractorportal.invoice.dto;

public class AmountsBuilder {

	private AmountsType amounts = new AmountsType();
	
	public AmountsBuilder addTotalPrice(double value) {
		amounts.setTotalprice(value);
		return this;
	}
	
	public AmountsBuilder addTotalPriceWithVat(double value) {
		amounts.setTotalwithvat(value);
		return this;
	}
	
	public AmountsBuilder addCurrency(String value) {
		amounts.setCurrency(value);
		return this;
	}

	public AmountsType getAmounts() {
		return amounts;
	}
	
}
