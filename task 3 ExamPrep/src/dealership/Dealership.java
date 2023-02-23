package dealership;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Dealership {
    private Collection<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }


    public boolean buy(String manufacturer, String model) {
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

//    public Car getLatestCar() {
//        Car car = null;
//        int latestYear = Integer.MIN_VALUE;
//        for (Car c : this.data) {
//            if (c.getYear() > latestYear) {
//                latestYear = c.getYear();
//                car = c;
//            }
//        }
//        return car;
//    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer))
                .filter(c -> c.getModel().equals(model))
                .findFirst()
                .orElse(null);

    }

    public String getStatistics() {
        return String.format("The cars are in a car dealership %s:%n%s", this.name,
                this.data.stream()
                        .map(Car::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
