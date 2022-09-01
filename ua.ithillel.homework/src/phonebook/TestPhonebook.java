package phonebook;

public class TestPhonebook {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add(new PhonebookEntry("Vasya", "0997777777"));
        phonebook.add(new PhonebookEntry("Kolya", "0995555555"));
        phonebook.add(new PhonebookEntry("Vasya", "0997777776"));
        phonebook.add(new PhonebookEntry("Egor", "0994444444"));
        phonebook.add(new PhonebookEntry("Vitaly", "0997777345"));
        phonebook.add(new PhonebookEntry("Vitaly", "0997777346"));
        phonebook.add(new PhonebookEntry("Denys", "0997777778"));

        System.out.println(phonebook.find("Vasya"));
        System.out.println(phonebook.find("Vitaly"));

        System.out.println(phonebook.findAll("Vitaly"));
    }
}
