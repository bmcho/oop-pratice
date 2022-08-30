package org.example.gradecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GradeTest {

    @DisplayName("학접을 받으면, 학점에 맞는 Score 반환")
    @ParameterizedTest(name= "[{index}] {0} ===> {1}")
    @MethodSource
    void givenGrade_whenGetScore_thenReturnsDoubleTypeValue(String grade, double expected) {
        //given
        GradeCode g = GradeCode.findBy(grade);

        //when
        double score = g.getScore();

        //then
        assertThat(score).isEqualTo(expected);
        assertThat(g.getGrade()).isEqualTo(grade);
    }

    static Stream<Arguments> givenGrade_whenGetScore_thenReturnsDoubleTypeValue() {
        return Stream.of(
                arguments("A+", 4.5),
                arguments("A", 4.0),
                arguments("B+", 3.5),
                arguments("B", 3.0),
                arguments("C+", 2.5),
                arguments("C", 2.0),
                arguments("D+", 1.5),
                arguments("D", 1.0),
                arguments("F", 0.0)
        );
    }
    
    @DisplayName("잘못된 학점정보를 찾을 때 IllegalArgumentException 예외 발생")
    @Test
    void givenWrongGrade_whenFindByGradeCode_thenThrowIllegalArgumentException() {
        assertThatCode(() -> GradeCode.findBy("G"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}