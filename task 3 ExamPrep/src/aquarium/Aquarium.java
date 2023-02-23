package aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.capacity > getFishInPool() && !this.fishInPool.contains(fish)) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish fish = this.fishInPool.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (fish != null) {
            this.fishInPool.remove(fish);
            return true;
        }
        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    public String report() {
        return String.format("Aquarium: %s ^ Size: %d%n%s", this.name, this.size,
                this.fishInPool.stream()
                        .map(Fish::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());
    }
}
