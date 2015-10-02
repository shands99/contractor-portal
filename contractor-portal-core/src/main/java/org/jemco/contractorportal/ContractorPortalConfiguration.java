package org.jemco.contractorportal;

import org.jemco.contractorportal.timesheet.composite.TimesheetInvoiceService;
import org.jemco.contractorportal.timesheet.composite.TimesheetInvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories
@PropertySource("application.properties")
public class ContractorPortalConfiguration extends AbstractMongoConfiguration {

	@Autowired private AutowireCapableBeanFactory beanFactory;
	
	@Value("app.db.name") private String databaseName;
	
	@Value("app.db.host") private String host;
	
	@Value("app.db.port") private Integer port;
	
	@Bean
	public TimesheetInvoiceService timesheetInvoiceService() {
		return this.createBean(TimesheetInvoiceServiceImpl.class);
	}
	
	public <T> T createBean(Class<T> type) {
		return type.cast(beanFactory.createBean(type, AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR
				, true));
	}
	
	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return (port !=null && port >0) ? new Mongo(host, port):
			new Mongo(host) ;
	}
	
}
