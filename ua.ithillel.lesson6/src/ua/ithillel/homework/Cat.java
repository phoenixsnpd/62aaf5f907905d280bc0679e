package ua.ithillel.homework;

public class Cat extends Animal {
    private static int catCounter;

    public Cat() {
        catCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Too long distance");
        } else {
            System.out.println("The cat ran " + distance + " meters.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println("The cat can't swim");
    }

    public static int getCatCounter() {
        return catCounter;
    }
}