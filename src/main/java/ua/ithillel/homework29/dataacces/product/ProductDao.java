package ua.ithillel.homework29.dataacces.product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework29.dataacces.DaoService;
import ua.ithillel.homework29.entity.Product;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class ProductDao implements DaoService<Product> {
    private static final String FIND_ALL_QUERY = "SELECT product_id, product_name, price FROM products";
    private static final String FIND_BY_ID_QUERY = "SELECT product_id, product_name, price " +
            "FROM products WHERE product_id = ?";
    private static final String CREATE_QUERY = "INSERT INTO products (product_name, price) VALUES (?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM products WHERE product_id = ?";

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Iterable<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new ProductMapper());
    }

    @Override
    public Optional<Product> FindById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new ProductMapper(), id));
    }

    @Override
    public void add(Product product) {
        jdbcTemplate.update(CREATE_QUERY, new ProductMapper(), product.getName(), product.getPrice());
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
}
