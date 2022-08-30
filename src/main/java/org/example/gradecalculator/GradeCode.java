package org.example.gradecalculator;

import java.util.Arrays;

public enum GradeCode {
    APLUS(4.5, "A+"),
    A(4.0, "A"),
    BPLUS(3.5, "B+"),
    B(3.0, "B"),
    CPLUS(2.5, "C+"),
    C(2, "C"),
    DPLUS(1.5, "D+"),
    D(1, "D"),
    F(0, "F");

    private final double score;
    private final String grade;

    GradeCode(double score, String grade) {
        this.score = score;
        this.grade = grade;
    }

    public double getScore() {
        return this.score;
    }

    public String getGrade() {
        return this.grade;
    }

    public static GradeCode findBy(String grade) {
        return Arrays.stream(values())
                .filter(v -> v.getGrade().equals(grade))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 학점정보 입니다."));
    }
}
