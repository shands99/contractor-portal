package org.jemco.contractorportal.invoice;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;

import org.jemco.contractorportal.contractor.dto.Company;
import org.jemco.contractorportal.contractor.dto.Contractor;
import org.jemco.contractorportal.contractor.dto.ContractorInfo;
import org.jemco.contractorportal.invoice.dto.AmountsBuilder;
import org.jemco.contractorportal.invoice.dto.ClientBuilder;
import org.jemco.contractorportal.invoice.dto.CompanyBuilder;
import org.jemco.contractorportal.invoice.dto.Header;
import org.jemco.contractorportal.invoice.dto.HeaderBuilder;
import org.jemco.contractorportal.invoice.dto.Invoice;
import org.jemco.contractorportal.invoice.dto.ItemBuilder;
import org.jemco.contractorportal.invoice.dto.ItemType;
import org.jemco.contractorportal.invoice.dto.ItemsType;
import org.junit.Test;

public class Utils {

	private Date createDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}
	
	private ItemType createItem(double days, Date wc) {
		return new ItemBuilder()
			.addDays(days)
			.addRate(500)
			.addType("Consultancy Services")
			.addVatRate(20)
			.addWeekCommencing(wc)
			.getItem();
	}
	
	@Test
	public void test_config() {
		ContractorInfo config = new ContractorInfo();
		
		Company com = new CompanyBuilder()
		.addAccount("31582844")
		.addSortcode("40-05-31")
		.addCompanyName("JEMCO Solutions Ltd")
		.addRegNo("09051612")
		.addVatNo("190 5297 91")
		.getCompany();
		
		com.setCompanyid("XX");
		config.setCompany(com);
		
		Contractor contractor = new Contractor();
		contractor.setCompany(com);
		contractor.setContractorid("SS");
		config.setContractor(contractor);
		
		Writer w = new StringWriter();
		XmlUtils.marshallToXml("org.jemco.contractorportal.contractor.dto", w, config);
		System.out.println(w.toString());
	}
	
	@Test
	public void test_output() {
		
		Writer w = new StringWriter();
		XmlUtils.marshallToXml("org.jemco.contractorportal.invoice.dto", w, createFoXml1());
		System.out.println(w.toString());
	}
	
	private Invoice createFoXml1() {
		
		Invoice invoice = new Invoice();
		Header header = new HeaderBuilder().addInvoiceDate(createDate(2015, Calendar.SEPTEMBER, 14))
				.addInvoiceDue(createDate(2015, Calendar.OCTOBER, 14))
				.addInvoiceNumber("1018")
						.getHeader();
		
		header.setCompany(new CompanyBuilder()
			.addAccount("31582844")
			.addSortcode("40-05-31")
			.addCompanyName("JEMCO Solutions Ltd")
			.addRegNo("09051612")
			.addVatNo("190 5297 91")
			.getCompany());
		
		header.setClient(new ClientBuilder()
			.addCompanyName("Carbon60 Recruitment LTD")
			.getClient());
		 
		invoice.setItems(new ItemsType());
		invoice.getItems().getItem().add(createItem(4, createDate(2015, Calendar.AUGUST, 31)));
			
		invoice.setHeader(header);
		invoice.setAmounts(new AmountsBuilder()
			.addCurrency("gbp")
			.addTotalPrice(InvoiceUtils.calculateTotalsNoVat(invoice.getItems().getItem()))
			.addTotalPriceWithVat(InvoiceUtils.calculateTotalsWithVat(invoice.getItems().getItem()))
			.getAmounts());
		return invoice;
	}
	
}
