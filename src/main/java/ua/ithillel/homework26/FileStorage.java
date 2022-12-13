package ua.ithillel.homework26;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private List<Path> filesPaths = new ArrayList<>();

    public void add(Path filePath) {
        filesPaths.add(filePath);
    }

    public Path get(int index) {
        return filesPaths.get(index);
    }

    public List<Path> getFilesPaths() {
        return filesPaths;
    }
}