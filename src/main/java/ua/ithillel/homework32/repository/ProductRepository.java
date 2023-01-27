package ua.ithillel.homework32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ithillel.homework32.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
