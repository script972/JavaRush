package com.javarush.task.task15.task1530;

/**
 * Created by script972 on 15.04.2017.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();
    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
