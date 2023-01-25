package ua.ithillel.homework32.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework32.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements EntityRepository<Product>{
    @PersistenceContext
    private EntityManager emf;

    @Override
    public Optional<Product> findByID(long id) {
        return Optional.ofNullable(emf.find(Product.class, id));
    }

    @Override
    public List<Product> gettAll() {
        List<Product> products;
        try (Session session = emf.getEntityManagerFactory().unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            session.flush();
        }
        return products;
    }

    @Override
    public void add(Product product) {
      emf.persist(product);
      emf.flush();
      emf.clear();
      emf.close();
    }

    @Override
    public void delete(long id) {
        Product product = emf.find(Product.class, id);
        emf.remove(product);
        emf.flush();
        emf.clear();
        emf.close();
    }
}
