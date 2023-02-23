package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (parrot != null) {
            this.data.remove(parrot);
            return true;
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (parrot != null) {
            parrot.setAvailable(false);
        }
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldSpecies = new ArrayList<>();
        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldSpecies.add(parrot);
            }
        }
        return soldSpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        return String.format("Parrots available at %s:%n%s", this.name,
                this.data.stream()
                        .filter(Parrot::isAvailable)
                        .map(Parrot::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());
    }
}
