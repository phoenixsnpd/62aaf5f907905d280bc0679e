package ua.ithillel.homework26;

import java.nio.file.Path;
import java.util.List;

public interface StorageReader {
    byte[] read(Path filename);
    List<byte[]> read(Path filename, int chunkSize);
    List<byte[]> read(Resume resume);
}
