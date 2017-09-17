package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum  Dish {
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString(){
        return Arrays.toString(Dish.values()).substring(1, Arrays.toString(Dish.values()).length()-1);
    }
}
