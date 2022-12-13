package ua.ithillel.homework26;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileStorageTest {
    FileStorage fileStorage = new FileStorage();
    @TempDir
    Path tempDir;
    
    @Test
    void shoudReturnTrue_if_fileWasAddedSuccesfully() {
        fileStorage.add(tempDir.resolve("test.txt"));
        Assertions.assertEquals(1, fileStorage.getFilesPaths().size());
    }

    @Test
    @SneakyThrows
    void shoudReturnTrue_if_fileExists() {
        fileStorage.add(tempDir.resolve("test.txt"));
        Files.createFile(fileStorage.get(0));
        Assertions.assertTrue(Files.exists(fileStorage.get(0)));
    }
}
