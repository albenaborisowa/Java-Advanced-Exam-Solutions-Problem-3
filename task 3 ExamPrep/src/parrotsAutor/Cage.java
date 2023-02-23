package parrotsAutor;

import parrots.Parrot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<parrots.Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(parrots.Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public parrots.Parrot sellParrot(String name) {
        parrots.Parrot toReturn = null;
        for (parrots.Parrot parrot: this.data){
            if(parrot.getName().equals(name)){
                parrot.setAvailable(false);
                toReturn = parrot;
            }
        }
        return toReturn;
    }

    public List<parrots.Parrot> sellParrotBySpecies(String species) {
        List<parrots.Parrot> toReturn = new ArrayList<>();
        this.data.forEach(i -> {
            if (i.getSpecies().equals(species)) {
                i.setAvailable(false);
                toReturn.add(i);
            }
        });
        return toReturn;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot r: this.data) {
            if (r.isAvailable()) {
                sb.append(r.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

}