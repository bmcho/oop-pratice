package org.example.restaurant;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CustomerTest {

    @Test
    void givenNoting_when() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(
                new MenuItem("돈까스", 5000),
                new MenuItem("냉면", 7000),
                new MenuItem("쫄면", 4000)
        ));
        Cooking cooking = new Cooking();

        assertThatCode(() -> customer.order("쫄면", menu, cooking))
                .doesNotThrowAnyException();
    }
}
