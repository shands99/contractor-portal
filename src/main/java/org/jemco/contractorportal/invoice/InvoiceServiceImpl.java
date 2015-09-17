package org.jemco.contractorportal.invoice;

import java.io.StringWriter;
import java.io.Writer;

import org.jemco.contractorportal.invoice.dto.Invoice;
import org.jemco.contractorportal.utils.pdf.PdfGenerator;

public class InvoiceServiceImpl implements InvoiceService {

	private static final String XSLFO_PATH = "invoice_to_xslfo.xsl";
	
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
		
		// create pdf report		
		byte[] invoiceReport = getInvoicePdf(invoice);
		
		// persist
		
		return 0;
	}
	
}
