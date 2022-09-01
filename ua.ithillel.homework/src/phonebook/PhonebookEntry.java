package phonebook;


public class PhonebookEntry {
    private String name;
    private String number;

    public PhonebookEntry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhonebookEntry{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
