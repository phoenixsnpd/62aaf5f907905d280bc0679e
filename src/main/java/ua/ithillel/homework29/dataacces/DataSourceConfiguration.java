package ua.ithillel.homework29.dataacces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.ithillel.homework29.entity.Product;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class DataSourceConfiguration {
    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/cartsproducts");
        ds.setUsername("user");
        ds.setPassword("admin");

        return ds;
    }
}
