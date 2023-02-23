package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String result = null;

        if (getStudentCount() >= this.capacity) {
            result = "No seats in the university";
        }

        if (getStudent(student.getFirstName(), student.getLastName()) != null) {
            result = "Student is already in the university";
        }

        if (result == null) {
            students.add(student);
            result = String.format("Added student %s %s", student.firstName, student.lastName);
        }
        return result;
    }

    public Student getStudent(String firstname, String lastName) {
        for (Student student : this.students) {
            if (firstname.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
                return student;
            }
        }
        return null;
    }

    public String dismissStudent(Student student) {
        Student studentFound = getStudent(student.getFirstName(), student.getLastName());
        if (studentFound == null) {
            return "Student not found";
        }
        students.remove(student);
        return String.format("Removed student %s %s", studentFound.getFirstName(), studentFound.getLastName());
    }


    public String getStatistics() {
        return this.students.stream()
                .map(s -> String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                        , s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }


}
