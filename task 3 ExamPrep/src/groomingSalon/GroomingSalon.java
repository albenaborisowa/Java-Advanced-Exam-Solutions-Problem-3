package groomingSalon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class GroomingSalon {
    private Collection<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet pet = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (pet != null) {
            this.data.remove(pet);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The grooming salon has the following clients:%n%s",
                this.data.stream()
                        .map(Pet::print)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
