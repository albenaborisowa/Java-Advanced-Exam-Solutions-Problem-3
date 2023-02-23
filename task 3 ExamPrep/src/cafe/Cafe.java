package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
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
        return String.format("Employees working at Cafe %s:%n%s", this.name,
                this.employees.stream()
                        .map(Employee::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }
}
