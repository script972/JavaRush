package com.javarush.task.task14;

/**
 * Created by script972 on 26.02.2017.
 */
public class Car {
    private int speed;
    private int koleso;
    private int dveri;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getKoleso() {
        return koleso;
    }

    public void setKoleso(int koleso) {
        this.koleso = koleso;
    }

    public int getDveri() {
        return dveri;
    }

    public void setDveri(int dveri) {
        this.dveri = dveri;
    }

    public Car(int speed, int koleso, int dveri) {
        this.speed = speed;
        this.koleso = koleso;
        this.dveri = dveri;
    }
}
