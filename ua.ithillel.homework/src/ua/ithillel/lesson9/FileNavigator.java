package ua.ithillel.lesson9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileNavigator {
    private HashMap<String, List<FileData>> pathToFiles = new HashMap();

    public void add(String path, FileData fileData) {
        if (!pathToFiles.containsKey(path)) {
            List<FileData> newList = new ArrayList<>();
            newList.add(fileData);
            pathToFiles.put(path, newList);
        } else {
            pathToFiles.get(path).add(fileData);
        }
    }

    public List find(String path) {
        if (pathToFiles.containsKey(path)) {
            return pathToFiles.get(path);
        }
        return null;      // perhaps need to change
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> list = new ArrayList<>();
        List<FileData> listToReturn = new ArrayList<>();
        for (Map.Entry entry : pathToFiles.entrySet()) {
            list = (List) entry.getValue();
            /*list.stream()
                    .filter(x -> x.getSize() <= size)
                    .collect(Collectors.toList());
        }
        return list;*/
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSize() <= size) {
                    listToReturn.add(list.get(i));
                }
            }

        }
        return listToReturn;
    }

    public void remove(String path) {
        pathToFiles.remove(path);
    }
}
