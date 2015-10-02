<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:date="http://exslt.org/dates-and-times"
	extension-element-prefixes="date">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">

		<fo:root>
		
			<!-- A4: 217mm x 297mm body: 180mm x 280mm -->
			<fo:layout-master-set>
				<fo:simple-page-master margin-bottom="7mm"
					margin-left="19mm" margin-right="18mm" margin-top="1cm"
					master-name="invoice-page-master">
					<fo:region-body margin-bottom="20mm" margin-top="40mm" />
					<fo:region-before extent="30mm" />
					<fo:region-after extent="10mm" />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="invoice-page-master">

				<fo:static-content flow-name="xsl-region-before">
					<fo:block-container absolute-position="absolute"
						left="100mm" top="Omm">
						<fo:block>
							<fo:external-graphic src="url('quattroclix.png')" />
						</fo:block>
					</fo:block-container>
				</fo:static-content>

				<fo:static-content flow-name="xsl-region-after">
					<fo:block font-size="10pt" border-top="solid"
						border-top-color="black" padding-top="2mm">
						<fo:inline>
							(
							<xsl:value-of select="/invoice/header/company/companyname" />
							) registered in England No.
							<xsl:value-of select="/invoice/header/company/registration" />
						</fo:inline>
					</fo:block>
					<fo:block font-size="10pt">
						<fo:inline>
							VAT No:
							<xsl:value-of select="/invoice/header/company/vatno" />
						</fo:inline>
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="xsl-region-body">
					<fo:table width="100%">
						<fo:table-column column-width="50%" />
						<fo:table-column column-width="50%" />
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:table width="100%" font-size="12pt">
										<fo:table-column column-width="40%" />
										<fo:table-column column-width="60%" />
										<fo:table-body>
											<fo:table-row>
												<fo:table-cell>
													<fo:block>Invoice Number:</fo:block>
												</fo:table-cell>
												<fo:table-cell>
													<fo:block>
														<xsl:value-of select="/invoice/header/invoicenr" />
													</fo:block>
												</fo:table-cell>
											</fo:table-row>
											<fo:table-row>
												<fo:table-cell>
													<fo:block>Invoice Date:</fo:block>
												</fo:table-cell>
												<fo:table-cell>
													<fo:block>
														<xsl:value-of select="/invoice/header/invoicedate" />
													</fo:block>
												</fo:table-cell>
											</fo:table-row>
											<fo:table-row>
												<fo:table-cell>
													<fo:block>Invoice Due:</fo:block>
												</fo:table-cell>
												<fo:table-cell>
													<fo:block>
														<xsl:value-of select="/invoice/header/due" />
													</fo:block>
												</fo:table-cell>
											</fo:table-row>
										</fo:table-body>
									</fo:table>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block font-size="12pt">
										<fo:block>
											<xsl:value-of select="/invoice/header/company/companyname" />
										</fo:block>
										<fo:block>
											<xsl:value-of select="/invoice/header/company/address1" />
											<xsl:if test="/invoice/header/company/address2">
												<xsl:text>,</xsl:text>&#160;
												<xsl:value-of select="/invoice/header/company/address2" />
											</xsl:if>
										</fo:block>
										<fo:block>
											<xsl:value-of select="/invoice/header/company/city" />
										</fo:block>
										<fo:block>
											Account:
											<xsl:value-of select="/invoice/header/company/account" />
										</fo:block>
										<fo:block>
											Sort-code:
											<xsl:value-of select="/invoice/header/company/sortcode" />
										</fo:block>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					
					<fo:block padding-top="10mm" font-size="12pt">
						<fo:block>TO: <xsl:value-of select="/invoice/header/client/company" /></fo:block>
						<xsl:if test="/invoice/header/client/name">
							<fo:block>ATTN OF: <xsl:value-of select="/invoice/header/client/firstname" />, <xsl:value-of select="/invoice/header/client/name" /></fo:block>
						</xsl:if>
					</fo:block>

					<fo:block padding-top="20mm">
						<fo:block font-family="sans-serif" font-size="10pt"
							margin-top="10mm">
							<fo:table border-style="solid" table-layout="fixed"
								width="100%">
								<fo:table-column column-width="95mm" />
								<fo:table-column column-width="15mm" />
								<fo:table-column column-width="25mm" />
								<fo:table-column column-width="15mm" />
								<fo:table-column column-width="23mm" />
								<fo:table-header background-color="silver"
									text-align="center">
									<fo:table-row>
										<fo:table-cell border-style="solid" padding="1mm">
											<fo:block font-weight="bold">Service Description</fo:block>
										</fo:table-cell>
										<fo:table-cell border-style="solid" padding="1mm">
											<fo:block font-weight="bold">Days</fo:block>
										</fo:table-cell>
										<fo:table-cell border-style="solid" padding="1mm">
											<fo:block font-weight="bold">Rate</fo:block>
										</fo:table-cell>
										<fo:table-cell border-style="solid" padding="1mm">
											<fo:block font-weight="bold">VAT</fo:block>
										</fo:table-cell>
										<fo:table-cell border-style="solid" padding="1mm">
											<fo:block font-weight="bold">Price</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-header>
								<fo:table-body>
									<xsl:apply-templates select="/invoice/items/*" />
									<fo:table-row>
										<fo:table-cell number-columns-spanned="5"
											padding="1mm" padding-top="2mm">
											<fo:block font-style="backslant" text-align="right"
												font-weight="bold">
												<fo:inline padding-right="7mm">Total - VAT</fo:inline>
												<fo:inline>
													<xsl:value-of select="/invoice/amounts/totalprice" />
													&#160;
													<xsl:value-of select="/invoice/amounts/currency" />
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="5"
											padding="1mm" padding-top="2mm">
											<fo:block font-style="backslant" text-align="right"
												font-weight="bold">
												<fo:inline padding-right="7mm">Total + VAT</fo:inline>
												<fo:inline>
													<xsl:value-of select="/invoice/amounts/totalwithvat" />
													&#160;
													<xsl:value-of select="/invoice/amounts/currency" />
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
					</fo:block>
				</fo:flow>

			</fo:page-sequence>
		</fo:root>

	</xsl:template>

	<xsl:template match="item">

		<fo:table-row>
			<fo:table-cell padding="1mm">
				<fo:block>
					<xsl:value-of select="type" />
					<xsl:text>,  w/c : </xsl:text>
					<xsl:value-of select="weekcommencing" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding="1mm">
				<fo:block>
					<xsl:value-of select="days" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding="1mm">
				<fo:block>
					<xsl:value-of select="rate" />
					&#160;
					<xsl:value-of select="/invoice/amounts/currency" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding="1mm">
				<fo:block>
					<xsl:value-of select="vatrate" />
					&#37;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell padding="1mm">
				<fo:block text-align="right">
					<xsl:value-of select="rate * days" />
					&#160;
					<xsl:value-of select="/invoice/amounts/currency" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

	</xsl:template>

</xsl:stylesheet>
