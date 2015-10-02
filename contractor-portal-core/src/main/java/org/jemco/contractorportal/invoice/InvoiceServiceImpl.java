package org.jemco.contractorportal.invoice;

import java.io.StringWriter;
import java.io.Writer;

import org.jemco.contractorportal.invoice.dto.ClientType;
import org.jemco.contractorportal.invoice.dto.Invoice;
import org.jemco.contractorportal.utils.pdf.PdfGenerator;

public class InvoiceServiceImpl implements InvoiceService {

	private static final String XSLFO_PATH = "/invoice_to_xslfo.xsl";
	
	private static final String PACKAGE = "org.jemco.contractorportal.invoice.dto";
	
	private PdfGenerator pdfGeneratorService;
	
	@Override
	public byte[] getInvoicePdf(Invoice invoice) {
	
		Writer writer = new StringWriter();
	    XmlUtils.marshallToXml(PACKAGE, writer, invoice);
		return pdfGeneratorService.createFoPdf(XSLFO_PATH, writer.toString());
		
	}

	@Override
	public long createInvoice(Invoice invoice) {
		// validate
		
		
		// persist (invoice number is generated from sequence for this contractor)
		
		// create pdf report		
		byte[] invoiceReport = getInvoicePdf(invoice);
				
		
		return 0;
	}

	@Override
	public ClientType getClient(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
