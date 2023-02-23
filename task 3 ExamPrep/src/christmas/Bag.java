package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        Present present = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (present != null) {
            this.data.remove(present);
            return true;
        }
        return false;
    }


    public Present heaviestPresent() {
        return this.data.stream()
                .max(Comparator.comparing(Present::getWeight))
                .orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        return String.format("%s bag contains:%n%s", this.color,
                this.data.stream()
                        .map(Present::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
