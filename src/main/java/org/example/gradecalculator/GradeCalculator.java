package org.example.gradecalculator;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    //평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
    public double calculateGrade() {
        //(학점수×교과목 평점)의 합계
        double multipliedCreditAndCoursesGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCoursesGrade += course.multiplyCreditAdnCourseGrade();
        }

        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCoursesGrade / totalCompletedCredit;
    }
}
