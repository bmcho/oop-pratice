package org.example.calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * • 간단한 사칙연산을 할 수 있다.
 * • 양수로만 계산할 수 있다.
 * • 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다
 */

public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행")
    @Test
    void SimpleAdditionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행")
    @Test
    void SimpleSubtractionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "-", new PositiveNumber(2));

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("사칙 연산 테스트 수행 - enum")
    @ParameterizedTest(name = "[{index}] {0} {1} {2} = {3}")
    @MethodSource
    void givenTwoOperandAndOperator_whenCalculateMethodByEnum_thenReturnResult(int operand1, String operator, int operand2, int expected) {
        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> givenTwoOperandAndOperator_whenCalculateMethodByEnum_thenReturnResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("사칙 연산 테스트 수행 - interfaceImpl")
    @ParameterizedTest(name = "[{index}] {0} {1} {2} = {3}")
    @MethodSource
    void givenTwoOperandAndOperator_whenCalculateMethodByInterfaceImpl_thenReturnResult(int operand1, String operator, int operand2, int expected) {
        int result = Calculator.calculate2(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> givenTwoOperandAndOperator_whenCalculateMethodByInterfaceImpl_thenReturnResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("나눗셈에서 0으로 나누는 경우 IllegalArgumentException 발생 - interfaceImple")
    @Test
    void givenSecondOperandZero_whenCalculate1_thenThrowIllegalArgumentException() {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Disabled("들어오는 수의 판단을 모두 PositiveNumber에 위임함으로써 현재 Test가 의미가 없음")
    @DisplayName("나눗셈에서 0으로 나누는 경우 IllegalArgumentException 발생 - interfaceImpl")
    @Test
    void givenSecondOperandZero_whenCalculate2_thenThrowIllegalArgumentException() {
        assertThatCode(() -> Calculator.calculate2(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
