package org.example.restaurant;

import java.util.Objects;

public class Cook {
    private final String menuName;
    private final int price;

    public Cook(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public Cook(MenuItem menuItem) {
        this.menuName = menuItem.getMenuName();
        this.price = menuItem.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(menuName, cook.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, price);
    }
}
