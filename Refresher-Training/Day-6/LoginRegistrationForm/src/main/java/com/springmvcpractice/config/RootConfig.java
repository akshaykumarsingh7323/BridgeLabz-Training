package com.springmvcpractice.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration

@PropertySource(
    "classpath:application.properties"
)


@ComponentScan({
    "com.springmvcpractice.service",
    "com.springmvcpractice.repository"
})


@EnableTransactionManagement

public class RootConfig {


    @Value("${db.driver}")
    private String driver;


    @Value("${db.url}")
    private String url;


    @Value("${db.username}")
    private String username;


    @Value("${db.password}")
    private String password;


    @Value("${hibernate.dialect}")
    private String dialect;


    @Value("${hibernate.show_sql}")
    private String showSql;


    @Value("${hibernate.format_sql}")
    private String formatSql;


    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;


    // Database Connection

    @Bean

    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();


        dataSource.setDriverClassName(
                driver
        );


        dataSource.setUrl(
                url
        );


        dataSource.setUsername(
                username
        );


        dataSource.setPassword(
                password
        );


        return dataSource;
    }


    // JPA + Hibernate

    @Bean

    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory() {


        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();


        factory.setDataSource(
                dataSource()
        );


        factory.setPackagesToScan(
                "com.springmvcpractice.entity"
        );


        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();


        factory.setJpaVendorAdapter(
                vendorAdapter
        );


        Properties properties =
                new Properties();


        properties.put(
                "hibernate.dialect",
                dialect
        );


        properties.put(
                "hibernate.show_sql",
                showSql
        );


        properties.put(
                "hibernate.format_sql",
                formatSql
        );


        properties.put(
                "hibernate.hbm2ddl.auto",
                hbm2ddlAuto
        );


        factory.setJpaProperties(
                properties
        );


        return factory;
    }


    // Transaction Manager

    @Bean

    public JpaTransactionManager
    transactionManager(
            EntityManagerFactory entityManagerFactory) {


        return new JpaTransactionManager(
                entityManagerFactory
        );
    }
}