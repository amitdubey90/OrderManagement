package com.catalog.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/testDB");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("summer");
		return driverManagerDataSource;
	}

	/*
	 * class MongoConfig extends AbstractMongoConfiguration {
	 * 
	 * @Override protected String getDatabaseName() { return "catalog"; }
	 * 
	 * @Override public Mongo mongo() throws Exception { Mongo mongo = new
	 * MongoClient("localhost",27017); mongo.setWriteConcern(WriteConcern.SAFE);
	 * return mongo; } }
	 */
}
