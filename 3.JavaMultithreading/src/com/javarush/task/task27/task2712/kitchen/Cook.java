package com.javarush.task.task27.task2712.kitchen;
import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    private final String name; // было без final

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';

    }

    @Override
    public void update(Observable obj, Object arg) {

        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + ((Order)arg).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(arg);
    }
}