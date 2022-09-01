package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuTest {

    @DisplayName("메뉴판을 생성하고, 해당하는 메뉴를 반환한다.")
    @Test
    void givenMenuItemList_whenCreateMenu_thenReturnsMenuItem() {
        Menu menu = new Menu(List.of(
                new MenuItem("돈까스", 5000),
                new MenuItem("냉면", 7000),
                new MenuItem("쫄면", 4000)
        ));

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 선택 시 IllegalArgumentException 반환")
    @Test
    void givenMenu_whenWrongChooseMenu_thenReturnIllegalArgumentException() {
        Menu menu = new Menu(List.of(
                new MenuItem("돈까스", 5000),
                new MenuItem("냉면", 7000),
                new MenuItem("쫄면", 4000)
        ));

        assertThatCode(() -> menu.choose("떡볶이"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
