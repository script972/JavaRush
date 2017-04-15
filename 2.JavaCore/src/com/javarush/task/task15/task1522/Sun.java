package com.javarush.task.task15.task1522;

/**
 * Created by script972 on 27.02.2017.
 */
public class Sun implements Planet {
    private static Sun instance;

    public static Sun getInstance() {
        if (instance == null) instance = new Sun();
        return instance;
    }

    private Sun() {
    }
}
