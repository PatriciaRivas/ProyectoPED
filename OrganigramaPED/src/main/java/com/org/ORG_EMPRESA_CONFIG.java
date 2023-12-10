package com.org;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "org_empEntityManager",
		transactionManagerRef = "org_empTransactionManager",
		basePackages = "com.org.org_emp.dao")
public class ORG_EMPRESA_CONFIG {
	
	@Bean(name="org_empDS")
	@ConfigurationProperties("empresa.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name= "org_empEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("org_empDS") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.org.org_emp.entity")
				.persistenceUnit("empresa")
				.build();
	}
	
	@Primary
	@Bean(name="org_empTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("org_empEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
