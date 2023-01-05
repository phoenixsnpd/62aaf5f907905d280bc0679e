package ua.ithillel.homework29.dataacces.cart;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework29.dataacces.DaoService;
import ua.ithillel.homework29.entity.Cart;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class CartDao implements DaoService<Cart> {
    private static final String FIND_BY_ID_QUERY = """
            SELECT c.id, p.product_id, p.product_name, p.price, c.cart_name
                             FROM products p
                             JOIN products_carts pc on pc.product_id = p.product_id
                             JOIN carts c on c.id = pc.cart_id
                             WHERE cart_id = ?;""";
    private static final String CREATE_QUERY = "INSERT INTO carts (id, cart_name) VALUES (?, ?)";
    private  static final String DELETE_QUERY = "DELETE FROM carts WHERE id = ?";
    private final JdbcTemplate jdbcTemplate;

    public CartDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Cart> FindById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new CartMapper(), id));
    }

    @Override
    public void add(Cart cart) {
        jdbcTemplate.update(CREATE_QUERY,cart.getId(), cart.getName());
    }

    @Override
    public void delete(long id) {
    jdbcTemplate.update(DELETE_QUERY, id);
    }
}
