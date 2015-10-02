package org.jemco.contractorportal.invoice.dto;

import java.util.Date;

public class ItemBuilder {

	private ItemType item = new ItemType();
	
	public ItemBuilder addType(String type) {
		item.setType(type);
		return this;
	}
	
	public ItemBuilder addDays(double days) {
		item.setDays(days);
		return this;
	}
	
	public ItemBuilder addRate(double value) {
		item.setRate(value);
		return this;
	}
	
	public ItemBuilder addVatRate(int value) {
		item.setVatrate(value);
		return this;
	}
	
	public ItemBuilder addWeekCommencing(Date date) {
		item.setWeekcommencing(date);
		return this;
	}

	public ItemType getItem() {
		return item;
	}
	
	
	
}
