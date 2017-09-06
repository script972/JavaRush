package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by script972 on 05.07.2017.
 */
public class Snake {

    private ArrayList <SnakeSection> sections=new ArrayList<>();

    private boolean isAlive;

    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections.add(new SnakeSection(x,y));
        isAlive=true;
    }

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){
        if(isAlive){
            switch (direction){
                case UP: move(0, -1); break;
                case RIGHT: move(1, 0); break;
                case DOWN: move(0, 1); break;
                case LEFT: move(-1, 0); break;
            }
        }
    }


    public void move(int dx, int dy){
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        //Проверяем - не вылезла ли голова за границу комнаты
        checkBorders(head);
        if (!isAlive) return;

        //Проверяем - не пересекает ли змея  саму себя
        checkBody(head);
        if (!isAlive) return;

        //Проверяем - не съела ли змея мышь.
        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) //съела
        {
            sections.add(0, head);                  //Добавили новую голову
            Room.game.eatMouse();                   //Хвот не удаляем, но создаем новую мышь.
        } else //просто движется
        {
            sections.add(0, head);                  //добавили новую голову
            sections.remove(sections.size() - 1);   //удалили последний элемент с хвоста
        }


    }

    public void checkBorders (SnakeSection head){
        int headX = head.getX();
        int headY = head.getY();
        int widthRoom = Room.game.getWidth();
        int heightRoom = Room.game.getHeight();

        if (headX<0 || headX>=widthRoom || headY<0 || headY>=heightRoom){
            isAlive = false;
        }
        System.out.println(isAlive);
    }

    public void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive=false;
        }
    }
}
