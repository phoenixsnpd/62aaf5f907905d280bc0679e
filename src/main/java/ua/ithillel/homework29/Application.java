package ua.ithillel.homework29;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.homework29.dataacces.cart.CartDao;
import ua.ithillel.homework29.dataacces.product.ProductDao;
import ua.ithillel.homework29.entity.Cart;

import java.util.Optional;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("ua.ithillel.homework29");

        ProductDao pd = context.getBean(ProductDao.class);
        CartDao cd = context.getBean(CartDao.class);
        Optional<Cart> cart = cd.FindById(2);
        System.out.println(cart.get());

        context.close();
    }
}
