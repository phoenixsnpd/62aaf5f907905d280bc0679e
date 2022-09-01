package phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<PhonebookEntry> phonebookEntries = new ArrayList<>();

    public void add(PhonebookEntry phonebookEntry) {
        phonebookEntries.add(phonebookEntry);
    }

    public PhonebookEntry find(String name) {
        for (PhonebookEntry phonebookEntry : phonebookEntries)
        if (phonebookEntry.getName().equals(name)) {
            return phonebookEntry;
        }
        return null;
    }

    public List<PhonebookEntry> findAll(String name) {
            List<PhonebookEntry> findNames = new ArrayList();
            for (PhonebookEntry entryName : phonebookEntries) {
                if (entryName.getName().equals(name)) {
                    findNames.add(entryName);
                }
            }
            return !findNames.isEmpty() ? findNames : null;
        }

    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries;
    }
}
