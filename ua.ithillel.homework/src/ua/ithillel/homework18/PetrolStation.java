package ua.ithillel.homework18;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class PetrolStation {
    private AtomicReference<Double> amount = new AtomicReference<>(0.0);
    private Semaphore semaphore = new Semaphore(3);

    public PetrolStation(Double amount) {
        this.amount.set(amount);
    }

    public synchronized void doRefuel(Integer fuel) {
        try {
            semaphore.acquire();
        if (amount.get() < fuel) {
            System.out.println("Not enough fuel");
            return;
        }
        int seconds = (int) (Math.random() * 8) + 3;
            TimeUnit.SECONDS.sleep(seconds);
            amount.set(amount.get() - fuel);        //amount = amount - fuel;
            System.out.println(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

