package org.jemco.contractorportal.invoice;

import java.util.List;

import org.jemco.contractorportal.invoice.dto.ItemType;

public class InvoiceUtils {
	
	public static double calculateTotalsWithVat(List<ItemType> invoiceItems) {
		
		double total = 0;
		
		for (ItemType item : invoiceItems) {
			double minusVat = (item.getRate() * item.getDays());
			double vat = item.getVatrate() > 0 ? (minusVat / 100) * item.getVatrate() : 0;
			total += (minusVat + vat);
		}
		
		return total;
		
	}
	
	public static double calculateTotalsNoVat(List<ItemType> invoiceItems) {
		
		double total = 0;
		
		for (ItemType item : invoiceItems) {
			total += (item.getRate() * item.getDays());
		}
		
		return total;
		
	}
	
}
