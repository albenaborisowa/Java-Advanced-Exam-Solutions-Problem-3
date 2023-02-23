package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.capacity > this.data.size()) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        Elephant elephant = this.data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (elephant != null) {
            this.data.remove(elephant);
            return true;
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream()
                .max(Comparator.comparing(Elephant::getAge))
                .orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        return String.format("Saved elephants in the park:%n%s",
                this.data.stream()
                        .map(Elephant::print)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());
    }
}
