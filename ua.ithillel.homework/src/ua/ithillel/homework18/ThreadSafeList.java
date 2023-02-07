package ua.ithillel.homework18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<E> {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private List<E> threadSafeValue = new ArrayList<>();

    public void add(E e) {
        try {
            lock.writeLock().lock();
            threadSafeValue.add(e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(E e) {
        try {
            lock.writeLock().lock();
            threadSafeValue.remove(e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public E get(int index) {
        try {
            lock.readLock().lock();
            return threadSafeValue.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }
}
