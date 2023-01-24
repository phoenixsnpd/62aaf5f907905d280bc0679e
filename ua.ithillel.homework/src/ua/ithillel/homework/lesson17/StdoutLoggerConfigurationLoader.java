package ua.ithillel.homework.lesson17;

import java.util.Scanner;

public class StdoutLoggerConfigurationLoader implements LoggerLoader<StdoutLoggerConfiguration, Scanner>{
    @Override
    public StdoutLoggerConfiguration load(Scanner file) {
        System.out.println("Some logic");
        return null;
    }
}
