package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

public class Space {

    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos=new ArrayList<>();
    private ArrayList<Rocket> rockets=new ArrayList<>();
    private ArrayList<Bomb> bombs=new ArrayList<>();

    public static Space game;

    public static void main(String[] args) {

    }


    public void run(){

    }

    public void draw(){

    }

    public void sleep(int ms){

    }

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public void setUfos(ArrayList<Ufo> ufos) {
        this.ufos = ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public void setRockets(ArrayList<Rocket> rockets) {
        this.rockets = rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(ArrayList<Bomb> bombs) {
        this.bombs = bombs;
    }
}
