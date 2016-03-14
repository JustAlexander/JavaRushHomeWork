package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by alexandr on 14.03.16.
 */
public enum Dish {

    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        StringBuilder string = new StringBuilder();
        for (Dish dish : Dish.values()) {
            string.append(dish.name() + ", ");
        }
        string.deleteCharAt(string.length()-2);
        return string.toString().trim();
    }
}
