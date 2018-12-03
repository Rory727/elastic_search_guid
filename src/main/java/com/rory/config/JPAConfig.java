package com.rory.config;

import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.rory")
@EnableJpaRepositories
public class JPAConfig {
    @Bean
    public DataSource dataSource(){
      DataSource  datasource =   new DriverManagerDataSource();


        return datasource;
    }
    @Bean
    public EntityManagerFactory entityManagerFactory (){
        EntityManagerFactory jpa = new AbstractEntityManagerFactoryBean();
    }
}
