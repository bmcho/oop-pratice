package org.example.restaurant;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking) {
        Cook cook = cooking.makeCook(menu.choose(menuName));
    }
}
