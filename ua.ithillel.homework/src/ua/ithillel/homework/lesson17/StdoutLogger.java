package ua.ithillel.homework.lesson17;

public class StdoutLogger implements Logger {
    @Override
    public void debug(String str) {
        System.out.println("Some logic");
    }

    @Override
    public void info(String str) {
        System.out.println("Some logic");
    }
}
