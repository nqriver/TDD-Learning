package pl.myprojects.ddt.gradebook;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final String name;
    private List<Double> grades = new ArrayList<>();

    Subject(String name) {
        this.name = name;
    }

    public double getAverage() {
        double sum = 0;
        for (var grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }
}
