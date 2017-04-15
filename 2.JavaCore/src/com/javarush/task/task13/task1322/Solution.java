package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject stringObject = new StringObject().getInstance();
    }

    interface SimpleObject {
        SimpleObject getInstance();
    }

    public static class StringObject implements SimpleObject{
        public SimpleObject getInstance(){
            return new StringObject();
        }
    }

}
