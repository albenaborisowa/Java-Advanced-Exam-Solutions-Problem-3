package bakery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Bakery {
    private Collection<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee employee = this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (employee != null) {
            this.employees.remove(employee);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Bakery %s:%n%s", this.name,
                this.employees.stream()
                        .map(Employee::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
