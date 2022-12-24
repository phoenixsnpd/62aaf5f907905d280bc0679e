package ua.ithillel.homework28;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ua.ithillel.homework28");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        User user = context.getBean(User.class);
        user.start(productRepository);
    }
}
