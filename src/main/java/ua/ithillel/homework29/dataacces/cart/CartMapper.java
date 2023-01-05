package ua.ithillel.homework29.dataacces.cart;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.ithillel.homework29.entity.Cart;
import ua.ithillel.homework29.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartMapper implements RowMapper<Cart> {
    @SneakyThrows
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) {
        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();
        cart.setId(rs.getLong("id"));
        cart.setName(rs.getString("cart_name"));
        Product product = new Product();
        product.setId(rs.getLong("product_id"));
        product.setName(rs.getString("product_name"));
        product.setPrice(rs.getInt("price"));
        products.add(product);
        while (rs.next()) {
            product = new Product();
            product.setId(rs.getLong("product_id"));
            product.setName(rs.getString("product_name"));
            product.setPrice(rs.getInt("price"));
            products.add(product);
        }
        cart.setProducts(products);
        return cart;
    }
}
