package ua.ithillel.homework26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;

public class ResumeTest {
    Resume resume = new Resume();
    @TempDir
    Path tempDir1;

    @Test
    void shouldSetValue_10_to_chunk() {
        resume.setChunk(10);
        Assertions.assertEquals(10, resume.getChunk());

    }
    @Test
    void shoudReturnTrue_if_getLastReadFile_notNull() {
        resume.setLastReadFile(tempDir1.resolve("test1.txt"));
        Assertions.assertNotNull(resume.getLastReadFile());
    }
    @Test
    void shouldSetValue_11_to_lastReadBytePosition() {
        resume.setLastReadBytePosition(11);
        Assertions.assertEquals(11, resume.getLastReadBytePosition());
    }
}
