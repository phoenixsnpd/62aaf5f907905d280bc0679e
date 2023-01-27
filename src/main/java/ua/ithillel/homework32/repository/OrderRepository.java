package ua.ithillel.homework32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ithillel.homework32.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
