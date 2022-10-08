package ua.ithillel.homework.lesson17;

public interface LoggerLoader<T, E> {
    T load(E file);
}
