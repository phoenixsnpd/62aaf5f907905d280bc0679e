package ua.ithillel.homework.lesson17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FileLogger {
    private LocalDateTime createTime;
    private FileLoggerConfiguration fileLogConfig;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLogConfig = fileLoggerConfiguration;
    }

        public void debug (String message) {
        if (fileLogConfig.getLoggingLevel().equals(LoggingLevel.INFO)) {
            return;
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileLogConfig.getFile(), true))) {
            createTime = LocalDateTime.now();
            String dateFormat = createTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss"));
            String writing = "[" + dateFormat + "]" +
                    "[" + fileLogConfig.getLoggingLevel() + "]" + " Message: " + message + "\n";
            br.write(writing);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileLogConfig.getFile().length() > fileLogConfig.getFileMaxSize()) {
            createTime = LocalDateTime.now();
            String date = createTime.format(DateTimeFormatter.ofPattern("hh-mm-ss_dd.MM.yyyy"));
            File file = new File("log_" + date);
            fileLogConfig.setFile(file);
        }
        if (fileLogConfig.getFile().length() > fileLogConfig.getFileMaxSize()) {
            throw new FileMaxSizeReachedException("Permissible size exceeded. Max size is " +
                    fileLogConfig.getFileMaxSize() + " byte. Current size is " +
                    fileLogConfig.getFile().length() + " byte. Path to file: " +
                    fileLogConfig.getFile().getAbsolutePath());
        }
    }


    public void info(String message) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileLogConfig.getFile(), true))) {
            createTime = LocalDateTime.now();
            String dateFormat = createTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss"));
            String writing = "[" + dateFormat + "]" +
                    "[" + fileLogConfig.getLoggingLevel() + "]" + " Message: " + message + "\n";
            br.write(writing);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileLogConfig.getFile().length() > fileLogConfig.getFileMaxSize()) {
            createTime = LocalDateTime.now();
            String date = createTime.format(DateTimeFormatter.ofPattern("hh-mm-ss_dd.MM.yyyy"));
            File file = new File("log_" + date);
            fileLogConfig.setFile(file);
        }
        if (fileLogConfig.getFile().length() > fileLogConfig.getFileMaxSize()) {
            throw new FileMaxSizeReachedException("Permissible size exceeded. Max size is " +
                    fileLogConfig.getFileMaxSize() + " byte. Current size is " +
                    fileLogConfig.getFile().length() + " byte. Path to file: " +
                    fileLogConfig.getFile().getAbsolutePath());
        }
    }
}

