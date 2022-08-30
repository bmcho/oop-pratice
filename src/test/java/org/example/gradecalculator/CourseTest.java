package org.example.gradecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @DisplayName("과목(코스)을 생성")
    @Test
    void givenNothing_whenCreateCourse_thenDoseNotAnyException() {
        assertThatCode(() -> new Course("oop", 3, "A+"))
                .doesNotThrowAnyException();
    }
}
