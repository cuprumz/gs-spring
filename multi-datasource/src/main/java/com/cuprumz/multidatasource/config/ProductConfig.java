package com.cuprumz.multidatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.cuprumz.multidatasource.dao.db2",
        entityManagerFactoryRef = "productEntityManager",
        transactionManagerRef = "productTransactionManager"
)
public class ProductConfig {

    @Value("${db2.datasource.url}")
    private String databaseUrl;

    @Value("${db2.datasource.username}")
    private String username;

    @Value("${db2.datasource.password}")
    private String password;

    @Value("${db2.datasource.driver-class-name}")
    private String driverClassName;
    
    @Bean(name = "productDataSource")
    public DataSource productDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(databaseUrl)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("productDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.cuprumz.multidatasource.model")
                .persistenceUnit("db2")
                .build();
    }

    @Bean
    public PlatformTransactionManager productTransactionManager(
            @Qualifier("productEntityManager") EntityManagerFactory productEntityManager
    ) {

        return new JpaTransactionManager(productEntityManager);
    }
}