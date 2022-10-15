package ua.ithillel.lesson17;

import java.util.Arrays;

public class ValueCalculator {
    private int numbersSize = 10_000_000;
    private float[] numbers = new float[numbersSize];
    private int halfNumbersSize = numbers.length / 2;

    public void doCalc() {
        long startTime = System.currentTimeMillis();
        float[] halfNumbersOne = new float[halfNumbersSize];
        float[] halfNumbersTwo = new float[halfNumbersSize];
        Arrays.fill(numbers, 1);

        System.arraycopy(numbers, 0, halfNumbersOne, 0, halfNumbersSize);
        System.arraycopy(numbers, halfNumbersSize, halfNumbersTwo, 0, halfNumbersSize);

        NumberTransformationThread halfNumbOneTransform =
                new NumberTransformationThread("halfNumbOneTransform", halfNumbersOne);
        NumberTransformationThread halfNumbTwoTransform =
                new NumberTransformationThread("halfNumbTwoTransform", halfNumbersTwo);

        halfNumbOneTransform.start();
        halfNumbTwoTransform.start();

        try {
            halfNumbOneTransform.join();
            halfNumbTwoTransform.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(halfNumbersOne, 0, numbers, 0, halfNumbersSize);
        System.arraycopy(halfNumbersTwo, 0, numbers, halfNumbersSize, halfNumbersSize);

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total method execution time = " + totalTime);
    }
}

