package ua.ithillel.lesson9;

public class FileData {
    private String name;
    private int sizeInBytes;
    private String pathToFile;

    public FileData(String name, int size, String pathToFile) {
        this.name = name;
        this.sizeInBytes = size;
        this.pathToFile = pathToFile;
    }

    public String getName() {
        return name;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + sizeInBytes +
                ", pathToFile='" + pathToFile + '\'' +
                '}';
    }
}
