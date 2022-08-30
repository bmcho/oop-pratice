package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class PositiveNumberTest {

    @DisplayName("올바르지 않은 숫자를 매개변수로 받을 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void givenWrongInt_whenCreateInstancePositiveNumber_thenIllegalArgumentException(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}