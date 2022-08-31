package org.example.gradecalculator;

public class Course {
    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public double multiplyCreditAdnCourseGrade() {
        return this.credit * getGradeToNumber();
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        GradeCode grade = GradeCode.findBy(this.grade);
        return grade.getScore();
    }
}
