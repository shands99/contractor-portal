package org.jemco.contractorportal.invoice;

import java.util.Arrays;

import org.jemco.contractorportal.invoice.dto.ItemBuilder;
import org.jemco.contractorportal.invoice.dto.ItemType;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceUtilsTest {

	@Test
	public void test_calculateTotalsNoVat() {
		ItemType type1 = new ItemBuilder().addDays(2).addRate(100).addVatRate(10).getItem();
		ItemType type2 = new ItemBuilder().addDays(2).addRate(100).addVatRate(10).getItem();
		double ret = InvoiceUtils.calculateTotalsNoVat(Arrays.asList(new ItemType[]{type1, type2}));
		Assert.assertEquals(400, ret, 0.1);
	}
	
	@Test
	public void test_calculateTotalsWithVat() {
		ItemType type1 = new ItemBuilder().addDays(2).addRate(100).addVatRate(10).getItem();
		ItemType type2 = new ItemBuilder().addDays(2).addRate(100).addVatRate(0).getItem();
		double ret = InvoiceUtils.calculateTotalsWithVat(Arrays.asList(new ItemType[]{type1, type2}));
		Assert.assertEquals(420, ret, 0.1);
	}
	
}
