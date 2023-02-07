package ua.ithillel.homework18;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class PetrolStation {
    private double amount;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Semaphore semaphore = new Semaphore(3);

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(Integer fuel) {
        try {
            semaphore.acquire();
            lock.writeLock().lock();
            if (amount < fuel) {
            System.out.println("Not enough fuel");
            return;
        }
        int seconds = (int) (Math.random() * 8) + 3;
            TimeUnit.SECONDS.sleep(seconds);
            amount = amount - fuel;
            System.out.println(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
            semaphore.release();
        }
    }
}

