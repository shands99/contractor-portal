package org.jemco.contractorportal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContractorPortalApplication {
	
	public static void main(String[] args) {
		ContractorPortalApplication app = new ContractorPortalApplication();
		app.load();
	}
	
	public void load() {
		AnnotationConfigApplicationContext ctx = 
				   new AnnotationConfigApplicationContext();
				   ctx.register(ContractorPortalConfiguration.class);
				   ctx.refresh();
	}

	
}
