package ua.ithillel.homework.lesson17;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileLoggerConfigurationLoader {
    private final String FILE_PATH = "FILE";
    private final String LOGGING_LEVEL = "LEVEL";
    private final String MAX_SIZE = "MAX-SIZE";
    private final String FORMAT = "FORMAT";
    private LoggingLevel loglvl;

    public FileLoggerConfiguration load(File file) {
        Map<String, String> LogConfiguration = new HashMap<>();
        String[] splitStrings;

        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) {
                splitStrings = line.split(": ");
                LogConfiguration.put(splitStrings[0], splitStrings[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (LogConfiguration.get(LOGGING_LEVEL).equals("INFO")) {
            loglvl = LoggingLevel.INFO;
        } else if (LogConfiguration.get(LOGGING_LEVEL).equals("DEBUG")) {
            loglvl = LoggingLevel.DEBUG;
        }

        return new FileLoggerConfiguration(new File(LogConfiguration.get(FILE_PATH)),
                loglvl, Long.parseLong(LogConfiguration.get(MAX_SIZE)), LogConfiguration.get(FORMAT));
    }
}
