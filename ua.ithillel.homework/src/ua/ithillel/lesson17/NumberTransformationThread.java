package ua.ithillel.lesson17;

public class NumberTransformationThread extends Thread {
    private float[] numbers;

    public NumberTransformationThread(String name, float[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (float) (numbers[i] *
                    Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
