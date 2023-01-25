package ua.ithillel.homework32.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework32.entity.Order;
import ua.ithillel.homework32.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements EntityRepository<Order> {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public Optional<Order> findByID(long id) {
        return Optional.ofNullable(emf.find(Order.class, id));
    }

    @Override
    public List<Order> gettAll() {
        List<Order> orders;
        try (Session session = emf.getEntityManagerFactory().unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            orders = session.createQuery("SELECT o FROM Order o", Order.class).getResultList();
            session.flush();
        }
        return orders;
    }

    @Override
    public void add(Order order) {
        emf.persist(order);
        emf.flush();
        emf.clear();
        emf.close();
    }

    @Override
    public void delete(long id) {
        Order order = emf.find(Order.class, id);
        emf.remove(order);
        emf.flush();
        emf.clear();
        emf.close();
    }
}
