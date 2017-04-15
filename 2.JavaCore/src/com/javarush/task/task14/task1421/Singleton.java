package com.javarush.task.task14.task1421;

/**
 * Created by script972 on 26.02.2017.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
    private String name;
    private String Lname;

    public String getName() {
        return name;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Singleton() {
    }
}
