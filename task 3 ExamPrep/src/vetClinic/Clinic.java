package vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    //    public boolean remove(String name) {
//        Pet pet = this.data.stream()
//                .filter(p -> p.getName().equals(name))
//                .findFirst()
//                .orElse(null);
//
//        if (pet != null) {
//            this.data.remove(pet);
//            return true;
//        }
//        return false;
//    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    //    public Pet getOldestPet() {
//        return this.data.stream()
//                .max(Comparator.comparing(Pet::getAge))
//                .orElse(null);
//    }
    public Pet getOldestPet() {
        return Collections.max(data, Comparator.comparingInt(Pet::getAge));
    }

    public int getCount() {
        return this.data.size();
    }

    //    public String getStatistics() {
//        return String.format("The clinic has the following patients:%n%s",
//                this.data.stream()
//                        .map(Pet::print)
//                        .collect(Collectors.joining(System.lineSeparator()))
//                        .trim());
//    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");

        for (Pet p : data) {
            sb.append(System.lineSeparator())
                    .append(p.getName())
                    .append(" ")
                    .append(p.getOwner());
        }
        return sb.toString();
    }
}
