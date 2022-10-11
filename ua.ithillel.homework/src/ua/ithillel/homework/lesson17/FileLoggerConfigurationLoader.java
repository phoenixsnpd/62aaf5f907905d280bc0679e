package ua.ithillel.homework.lesson17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileLoggerConfigurationLoader implements LoggerLoader<FileLoggerConfiguration, File> {
    private File filePath;
    private String loglvlStr;
    private long maxSize;
    private String format;

    @Override
    public FileLoggerConfiguration load(File file) {
        List<String> lines = new ArrayList<>();
        String[] splitStrings;

        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lines.size(); i++) {
            splitStrings = lines.get(i).split(": ");
            if (i == 0) {
                filePath = new File(splitStrings[1]);
            } else if (i == 1) {
                loglvlStr = splitStrings[1];
            } else if (i == 2) {
                maxSize = Long.parseLong(splitStrings[1]);
            } else if (i == 3) {
                format = splitStrings[1];
            }
        }
        if (loglvlStr.equals("INFO")) {
            return new FileLoggerConfiguration(filePath, LoggingLevel.INFO, maxSize, format);
        }
        return new FileLoggerConfiguration(filePath, LoggingLevel.DEBUG, maxSize, format);
    }
}
