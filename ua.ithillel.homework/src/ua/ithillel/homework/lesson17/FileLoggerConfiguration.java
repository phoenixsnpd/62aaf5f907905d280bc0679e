package ua.ithillel.homework.lesson17;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private LoggingLevel loggingLevel;
    private long fileMaxSize;
    private String fileFormat = "[CURRENT_TIME][loggingLevel] Message: [MESSAGE]";

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, long fileMaxSize) {
        this.file = file;
        this.loggingLevel = loggingLevel;
        this.fileMaxSize = fileMaxSize;
    }

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, long fileMaxSize, String fileFormat) {
        this.file = file;
        this.loggingLevel = loggingLevel;
        this.fileMaxSize = fileMaxSize;
        this.fileFormat = fileFormat;
    }

    public File getFile() {
        return file;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public Long getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "file=" + file +
                ", loggingLevel=" + loggingLevel +
                ", fileMaxSize=" + fileMaxSize +
                ", fileFormat='" + fileFormat + '\'' +
                '}';
    }
}
