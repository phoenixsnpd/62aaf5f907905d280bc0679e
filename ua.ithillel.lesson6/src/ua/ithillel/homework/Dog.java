package ua.ithillel.homework;

public class Dog extends Animal {
    private static int dogCounter;

    public Dog() {
        dogCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Too long distance");
        } else {
            System.out.println("The dog ran " + distance + " meters.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Too long distance");
        } else {
            System.out.println("The dog swam " + distance + " meters.");
        }
    }

    public static int getDogCounter() {
        return dogCounter;
    }
}