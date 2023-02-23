package parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Parking {
    private Collection<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        Car car = this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer))
                .filter(c -> c.getModel().equals(model))
                .findFirst()
                .orElse(null);

        if (car != null) {
            this.data.remove(car);
            return true;
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The cars are parked in %s:%n%s", this.type,
                this.data.stream()
                        .map(Car::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());
    }
}
