package org.example.restaurant;

import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String menuName) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 메뉴 선택이 아닙니다."));
    }
}
