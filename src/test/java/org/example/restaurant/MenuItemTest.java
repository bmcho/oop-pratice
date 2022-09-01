package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuItemTest {
    @DisplayName("메뉴항목을 생성함에 있어 에러가 발생하면 안된다.")
    @Test
    void givenNothing_whenCreateCook_thenDoseNotAnyException() {
        assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
