package com.bookapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

//controller-service-dao-jdbctemplate-datasource
//controller-service-dao-hobernateTemplate-sessionfactory-datasou

@EnableTransactionManagement
@Configuration
public class DbConfig {

	@Autowired
	Environment env;
	@Bean
	public SessionFactory sessionFactory() throws SQLException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan("com.bookapp");
		factory.setDataSource(dataSource());
		factory.setHibernateProperties(hibernateProperties());
		try {
			factory.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory.getObject();
	}
	@Bean
	public HibernateTemplate hibernateTemplate() throws SQLException {
		return new HibernateTemplate(sessionFactory());
	}	@Bean
	public HibernateTransactionManager hibernateTransaction() throws SQLException {
		return new HibernateTransactionManager(sessionFactory());
	}
	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(env.getProperty("datasource.username"));
		dataSource.setURL(env.getProperty("datasource.url"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		return dataSource;
		
	}
	@Bean
	public Properties hibernateProperties() {
		// add hibernate property to this Properties class
		Properties property = new Properties();
		// add key as hibernate key(from cfg file)
		// get value from application.properties
		property.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		property.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		property.put("hibernate.show_sql", env.getProperty("show-sql"));
		return property;
	}
	

}
