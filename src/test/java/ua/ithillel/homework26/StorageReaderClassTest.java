package ua.ithillel.homework26;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class StorageReaderClassTest {
    @TempDir
    static Path tempFile;
    StorageReaderClass storageReaderClass = new StorageReaderClass();
    Path testFilePath = Path.of("src", "test", "resources", "hello.txt");

    @Test
    @SneakyThrows
    void initTestFile() {
        RandomAccessFile file = new RandomAccessFile(testFilePath.toFile(), "rw");
        FileChannel fch = file.getChannel();
        ByteBuffer buff = ByteBuffer.wrap("Hello World!".getBytes());
        fch.write(buff);
        Assertions.assertTrue(Files.exists(testFilePath));
    }

   @Test
    void shouldReturnTrueIf_2_arraysEquals() {
        Assertions.assertTrue(Arrays.equals("Hello World!".getBytes(), storageReaderClass.read(testFilePath)));
   }
}
