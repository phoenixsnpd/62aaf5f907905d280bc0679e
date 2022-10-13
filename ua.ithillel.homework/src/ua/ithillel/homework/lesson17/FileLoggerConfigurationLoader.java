package ua.ithillel.homework.lesson17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileLoggerConfigurationLoader implements LoggerLoader<FileLoggerConfiguration, File> {
    @Override
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

        return new FileLoggerConfiguration(new File(LogConfiguration.get(Configuration.PATH.getTitle())),
                LoggingLevel.valueOf(LogConfiguration.get(Configuration.LEVEL.getTitle())),
                Long.parseLong(LogConfiguration.get(Configuration.SIZE.getTitle())),
                LogConfiguration.get(Configuration.FORMAT.getTitle()));
    }
}
