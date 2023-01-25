package ua.ithillel.homework32.repository;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<T> {
    Optional<T> findByID(long id);

    List<T> gettAll();

    void add(T object);

    void delete(long id);
}
