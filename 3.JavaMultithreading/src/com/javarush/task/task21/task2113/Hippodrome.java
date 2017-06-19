package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by script972 on 19.06.2017.
 */
public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public static void main(String[] args) {
        List<Horse> hippodromes=new ArrayList<>();
        hippodromes.add(new Horse("lulu", 3,0));
        hippodromes.add(new Horse("kuku", 3,0));
        hippodromes.add(new Horse("susu", 3,0));
        Hippodrome hippodrome=new Hippodrome(hippodromes);

        game=hippodrome;
        game.run();
        game.printWinner();


    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void move(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }

    }

    public void print(){
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("");
        }
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");


    }

    public Horse getWinner(){
        Horse winner=horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if(winner.getDistance()<horses.get(i).getDistance())
                winner=horses.get(i);
        }
        return winner;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
