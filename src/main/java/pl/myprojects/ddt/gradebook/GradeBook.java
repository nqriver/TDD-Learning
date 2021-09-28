package pl.myprojects.ddt.gradebook;

import java.util.HashMap;
import java.util.Map;

public class GradeBook {

    private Map<String, Subject> subjects = new HashMap<>();

    public void addSubject(String subjectAsString) {
        if (subjects.containsKey(subjectAsString)) {
            throw new IllegalArgumentException(String.format("Subject %s already exists", subjectAsString));
        }
        subjects.put(subjectAsString, new Subject(subjectAsString));
    }

    public Subject getSubject(String subjectName) {
        if (subjects.containsKey(subjectName)) {
            return subjects.get(subjectName);
        }
        throw new IllegalArgumentException(String.format("Subject %s doesn't exist", subjectName));
    }

    public void addGrade(String subjectName, double grade) {
        Subject subject = getSubject(subjectName);
        subject.addGrade(grade);
    }

    public double getAverageGradeFromAllSubjects() {
        double gradeSum = 0;
        for (var subject : subjects.values()) {
            gradeSum += subject.getAverage();
        }
        return gradeSum / subjects.size();
    }
}
