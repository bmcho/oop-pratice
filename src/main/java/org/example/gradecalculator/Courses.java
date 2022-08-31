package org.example.gradecalculator;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAdnCourseGrade() {
        return this.courses.stream()
                .mapToDouble(Course::multiplyCreditAdnCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return this.courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
