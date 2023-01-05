package ua.ithillel.homework29.dataacces;

import java.util.Optional;

public interface DaoService<T> {
    Optional<T> FindById(long id);
    void add(T obj);
    void delete(long id);
}
