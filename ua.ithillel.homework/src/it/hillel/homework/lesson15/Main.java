package it.hillel.homework.lesson15;

public class Main {

    public static void main(String[] args) {
        ClassTests classTestOne = new ClassTests();
        Class<?> test = classTestOne.getClass();
        TestRunner.start(test);
    }
}
