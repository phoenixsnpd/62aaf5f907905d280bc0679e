package ua.ithillel.homework32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework32.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
