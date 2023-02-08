package ua.ithillel.homework32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework32.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
