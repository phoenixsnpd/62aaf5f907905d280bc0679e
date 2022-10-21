package ua.ithillel.homework18;

import java.util.concurrent.*;

public class PetrolStation {
    private double amount;
    private Semaphore semaphore = new Semaphore(3);

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public Runnable doRefuel(double fuel) {
        int seconds = (int) (Math.random() * 8) + 3;
        return () -> {
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(seconds);
                amount = amount - fuel;
                System.out.println(amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };
    }
}
