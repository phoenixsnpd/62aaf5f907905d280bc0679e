package ua.ithillel.lesson9;

import java.util.*;
import java.util.stream.Collectors;


public class FileNavigator {
    private Map<String, List<FileData>> pathToFiles = new HashMap();

    public void add(String path, FileData fileData) {
        if (!path.equals(fileData.getPathToFile())) {
            System.out.println("This path is wrong for file " + fileData.getName() + ". correct path is " + fileData.getPathToFile());
        }
        if (!pathToFiles.containsKey(path)) {
            List<FileData> newList = new ArrayList<>();
            newList.add(fileData);
            pathToFiles.put(path, newList);
        } else {
            pathToFiles.get(path).add(fileData);
        }
    }

    public List find(String path) {
        if (!pathToFiles.containsKey(path)) {
            System.out.println("This path is not exist");
            return null;
        }
        return pathToFiles.get(path);
    }

    public List<FileData> filterBySize(int size) {
        return pathToFiles.values().stream()
                .flatMap(List :: stream)
                .filter(x -> x.getSizeInBytes() <= size)
                .collect(Collectors.toList());
    }

    public void remove(String path) {
        pathToFiles.remove(path);
    }

    public List<FileData> sortBySize() {
        return pathToFiles.values().stream()
                .flatMap(List :: stream)
                .sorted(Comparator.comparingInt(FileData :: getSizeInBytes))
                .collect(Collectors.toList());
    }

}
