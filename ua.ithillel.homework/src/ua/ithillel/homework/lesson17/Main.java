package ua.ithillel.homework.lesson17;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileForLogs = new File("Test.txt");
        File fileWithConfig = new File("ConfigFile.txt");
        FileLoggerConfiguration fileLogConf = new FileLoggerConfiguration(fileForLogs,
                LoggingLevel.DEBUG, 100);

        Logger fileLogger = new FileLogger(fileLogConf);
        fileLogger.debug("Writing to the file");
        fileLogger.info("New writing to the file");

        FileLoggerConfigurationLoader fileLogConfLoader = new FileLoggerConfigurationLoader();
        System.out.println(fileLogConfLoader.load(fileWithConfig));

        Logger stdOutLogger = new StdoutLogger();
        stdOutLogger.debug("String");
    }
}
