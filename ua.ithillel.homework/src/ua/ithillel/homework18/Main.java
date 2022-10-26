package ua.ithillel.homework18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        PetrolStation fuelStation = new PetrolStation(90.0);
/*
        Semaphore sem = new Semaphore(3);
        PetrolStation fuelStation = new PetrolStation(90);

        Thread thread1 = new Thread(() -> {System.out.println("поток 1 начал работу"); fuelStation.doRefuel(30); System.out.println("поток 1 закончил работу");});
        Thread thread2 = new Thread(() -> {System.out.println("поток 2 начал работу"); fuelStation.doRefuel(30); System.out.println("поток 2 закончил работу");});
        Thread thread3 = new Thread(() -> {System.out.println("поток 3 начал работу"); fuelStation.doRefuel(30); System.out.println("поток 3 закончил работу");});
        Thread thread4 = new Thread(() -> {System.out.println("поток 4 начал работу"); fuelStation.doRefuel(10); System.out.println("поток 4 закончил работу");});
        Thread thread5 = new Thread(() -> {System.out.println("поток 5 начал работу"); fuelStation.doRefuel(20); System.out.println("поток 5 закончил работу");});
        Thread thread6 = new Thread(() -> {System.out.println("поток 6 начал работу"); fuelStation.doRefuel(30); System.out.println("поток 6 закончил работу");});



            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();

*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> fuelStation.doRefuel(30));
        executorService.submit(() -> fuelStation.doRefuel(30));
        executorService.submit(() -> fuelStation.doRefuel(30));
        executorService.submit(() -> fuelStation.doRefuel(10));
        executorService.submit(() -> fuelStation.doRefuel(20));
        executorService.submit(() -> fuelStation.doRefuel(30));

        executorService.shutdown();
    }
}
