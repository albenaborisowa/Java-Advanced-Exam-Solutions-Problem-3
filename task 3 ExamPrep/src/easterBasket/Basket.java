package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        Egg egg = this.data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);

        if (egg != null) {
            this.data.remove(egg);
            return true;
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparing(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        return String.format("%s basket contains:%n%s", this.material,
                this.data.stream()
                        .map(Egg::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());
    }
}
