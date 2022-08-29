package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 조건에 맞게 올바르게 초기화 한다")
    @Test
    void givenNothingWhenCorrectPasswordGenerateThenPasswordIIsNotnull() {
        //given
        User user = new User();

        //when
        user.initPassword(new CorrectPasswordGenerator()); // functional한 interface 이기 때문에 lambda식으로도 선언가능

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드를 조건에 맞지 않게 초기화")
    @Test
    void givenNothingWhenWrongPasswordGenerateThenPasswordIIsNull() {
        //given
        User user = new User();

        //when
        user.initPassword(new WrongPasswordGenerator()); //functional한 interface 이기 때문에 lambda식으로도 선언가능

        //then
        assertThat(user.getPassword()).isNull();
    }
}