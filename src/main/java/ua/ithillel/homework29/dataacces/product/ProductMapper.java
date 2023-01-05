package ua.ithillel.homework29.dataacces.product;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.ithillel.homework29.entity.Product;

import java.sql.ResultSet;


public class ProductMapper implements RowMapper<Product> {
    @SneakyThrows
    @Override
    public Product mapRow(ResultSet rs, int rowNum) {
        Product product = new Product();
        product.setId(rs.getLong("product_id"));
        product.setName(rs.getString("product_name"));
        product.setPrice(rs.getInt("price"));
        return product;
    }
}
