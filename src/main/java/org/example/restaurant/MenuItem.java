package org.example.restaurant;

import java.util.Objects;

public class MenuItem {
    private final String menuName;
    private final int price;

    public MenuItem(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public boolean matches(String menuName) {
        return this.menuName.equals(menuName);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return price == menuItem.price && Objects.equals(menuName, menuItem.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, price);
    }
}
