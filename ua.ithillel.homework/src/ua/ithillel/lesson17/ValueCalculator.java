package ua.ithillel.lesson17;

import java.util.Arrays;

public class ValueCalculator {
    private int numbersSize = 1_000_000;
    private float[] numbers = new float[numbersSize];
    private int halfNumbersSize = numbers.length / 2;

    public void doCalc() {
        long startTime = System.currentTimeMillis();
        float[] halfNumbersOne = new float[halfNumbersSize];
        float[] halfNumbersTwo = new float[halfNumbersSize];
        Arrays.fill(numbers, 1);

        System.arraycopy(numbers, 0, halfNumbersOne, 0, halfNumbersSize);
        System.arraycopy(numbers, halfNumbersSize, halfNumbersTwo, 0, halfNumbersSize);

        Thread t1 = new Thread(() -> fillArray(halfNumbersOne), "T2");
        Thread t2 = new Thread(() -> fillArray(halfNumbersTwo), "T1");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(halfNumbersOne, 0, numbers, 0, halfNumbersSize);
        System.arraycopy(halfNumbersTwo, 0, numbers, halfNumbersSize, halfNumbersSize);

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total method execution time = " + totalTime);
    }

    public void fillArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] *
                    Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}


