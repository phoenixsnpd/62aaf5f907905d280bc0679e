package ua.ithillel.lesson9;

public class TestFileNavigator {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData newFileData1 = new FileData("Text1", 5240, "/path/to/files/Texts");
        FileData newFileData2 = new FileData("Text2", 3111, "/path/to/files/Texts");

        FileData newFileData3 = new FileData("Photo1", 2097152, "/path/to/files/Photos");
        FileData newFileData4 = new FileData("Photo2", 3000123, "/path/to/files/Photos");

        FileData newFileData5 = new FileData("Aplication1", 5000123, "/path/to/files/Aplications");
        FileData newFileData6 = new FileData("Aplication2", 104567, "/path/to/files/Aplications");

        FileData newFileData7 = new FileData("FileForDelete", 10000000, "/path/to/files/OTHERFILES");

        fileNavigator.add("/path/to/files/Texts", newFileData1);
        fileNavigator.add("/path/to/files/Texts", newFileData2);
        fileNavigator.add("/path/to/files/Photos", newFileData3);
        fileNavigator.add("/path/to/files/OTHERFILES", newFileData4);
        fileNavigator.add("/path/to/files/Aplications", newFileData5);
        fileNavigator.add("/path/to/files/Aplications", newFileData6);
        fileNavigator.add("/path/to/files/OTHERFILES", newFileData7);

        fileNavigator.remove("/path/to/files/OTHERFILES");

        System.out.println(fileNavigator.filterBySize(10000));

        System.out.println(fileNavigator.sortBySize());

        System.out.println(fileNavigator.find("/path/to/files/Texts"));
    }
}
