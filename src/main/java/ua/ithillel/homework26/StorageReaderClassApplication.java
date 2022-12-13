package ua.ithillel.homework26;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class StorageReaderClassApplication {

    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.add(Path.of("test_file.txt"));

        StorageReaderClass storageReaderClass = new StorageReaderClass();
        storageReaderClass.read(fileStorage.get(0));
        System.out.println(Arrays.toString(storageReaderClass.read(fileStorage.get(0))));

        List<byte[]> arrayList = storageReaderClass.read(fileStorage.get(0), 3);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(Arrays.toString(arrayList.get(i)));
        }
    }
}
