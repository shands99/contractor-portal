package org.jemco.contractorportal.timesheet.composite;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jemco.contractorportal.contractor.ContractorService;
import org.jemco.contractorportal.contractor.dto.ContractorInfo;
import org.jemco.contractorportal.invoice.InvoiceService;
import org.jemco.contractorportal.invoice.InvoiceUtils;
import org.jemco.contractorportal.invoice.dto.AmountsBuilder;
import org.jemco.contractorportal.invoice.dto.ClientType;
import org.jemco.contractorportal.invoice.dto.HeaderBuilder;
import org.jemco.contractorportal.invoice.dto.Invoice;
import org.jemco.contractorportal.invoice.dto.InvoiceStatus;
import org.jemco.contractorportal.invoice.dto.ItemBuilder;
import org.jemco.contractorportal.invoice.dto.ItemsType;
import org.jemco.contractorportal.timesheet.TimesheetService;
import org.jemco.contractorportal.timesheet.dto.Timesheet;
import org.jemco.contractorportal.timesheet.dto.TimesheetStatusType;

@Singleton
public class TimesheetInvoiceServiceImpl implements TimesheetInvoiceService {

	private ContractorService contractorService;
	
	private static final String WORK_TYPE = "Consultancy Services";
	
	private static final Integer STD_VAT_RATE = 20;
	
	private static final Integer STD_PAY_TERMS = 30;
	
	private TimesheetService timesheetService;
	
	private InvoiceService invoiceService;
	
	@Inject
	public TimesheetInvoiceServiceImpl(ContractorService contractorService,
			TimesheetService timesheetService,
			InvoiceService invoiceService) {
		super();
		this.contractorService = contractorService;
		this.timesheetService = timesheetService;
		this.invoiceService = invoiceService;
	}

	@Override
	public Invoice createInvoiceFromTimesheets(List<Timesheet> timesheets) {
		
		// TODO check input parms
		
		// get info id from first ts
		String id = timesheets.size() > 0 ? timesheets.get(0).getContractorinfoid() : null;
				
		ContractorInfo info = contractorService.getContractorInfoById(id);
		ClientType client = invoiceService.getClient(info.getContract().getClientid());
		
		Invoice invoice = new Invoice();
		invoice.setHeader(new HeaderBuilder()
			.addInvoiceDate(new Date())
			.addInvoiceDue(InvoiceUtils.calculateDueDate(STD_PAY_TERMS, new Date()))
			.getHeader());
		invoice.getHeader().setCompany(info.getCompany());
		invoice.getHeader().setClient(client);
		invoice.setItems(new ItemsType());
		
		for(Timesheet ts : timesheets) {
			
			// TODO check w/c date is < contract end date
			// TODO check timesheet is approved
			
			invoice.getItems().getItem().add(new ItemBuilder()
				.addDays(ts.getDays())
				.addWeekCommencing(ts.getWeekCommencing())
				.addRate(info.getContract().getRate())
				.addType(WORK_TYPE)
				.addVatRate(STD_VAT_RATE)
				.getItem());
			
			ts.setStatus(TimesheetStatusType.INVOICED);
			
		}
		
		invoice.setAmounts(new AmountsBuilder()
			.addCurrency(info.getContract().getCurrency())
			.addTotalPrice(InvoiceUtils.calculateTotalsNoVat(invoice.getItems().getItem()))
			.addTotalPriceWithVat(InvoiceUtils.calculateTotalsWithVat(invoice.getItems().getItem()))
			.getAmounts());
		
		//create invoice and create pdf etc.
		invoice.setStatus(InvoiceStatus.NEW);
		invoiceService.createInvoice(invoice);
		
		//update timesheets to invoiced
		this.timesheetService.updateTimesheets(timesheets);
		
		return invoice;
		
	}
	
	
	
}
