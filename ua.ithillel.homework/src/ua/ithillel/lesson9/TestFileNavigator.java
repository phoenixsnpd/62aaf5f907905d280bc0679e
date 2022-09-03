package ua.ithillel.lesson9;

public class TestFileNavigator {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        FileData newFileData = new FileData("...", 20, "123");
        FileData newFileData1 = new FileData("Hello", 11, "123");
        FileData newFileData2 = new FileData("Bye", 10, "123");

        FileData newFileData3 = new FileData("Denys", 30, "444");
        FileData newFileData4 = new FileData("Polukhin", 1, "444");

        fileNavigator.add("123", newFileData);
        fileNavigator.add("123", newFileData1);
        fileNavigator.add("123", newFileData2);
        fileNavigator.add("444", newFileData3);
        fileNavigator.add("444", newFileData4);

        System.out.println(fileNavigator.filterBySize(12));
    }
}
