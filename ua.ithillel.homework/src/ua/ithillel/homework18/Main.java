package ua.ithillel.homework18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PetrolStation fuelStation = new PetrolStation(1000.0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(fuelStation.doRefuel(20));
        executorService.submit(fuelStation.doRefuel(30));
        executorService.submit(fuelStation.doRefuel(15));
        executorService.submit(fuelStation.doRefuel(5));
        executorService.submit(fuelStation.doRefuel(5));
        executorService.submit(fuelStation.doRefuel(80));

        executorService.shutdown();
    }
}
