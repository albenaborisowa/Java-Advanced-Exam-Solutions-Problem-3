package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public int getCount() {
        return this.roster.size();
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (name.equals(person.getName()) && hometown.equals(person.getHometown())) {
                return person;
            }
        }
        return null;
    }

    public void add(Person person) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = this.roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (person != null) {
            this.roster.remove(person);
            return true;
        }
        return false;
    }

    public String getStatistics() {
        return String.format("The people in the hotel %s are:%n%s", this.name,
                this.roster.stream()
                        .map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
