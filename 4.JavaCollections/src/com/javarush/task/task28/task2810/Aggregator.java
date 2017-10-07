package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

public class Aggregator  {
//    https://github.com/mrShahid/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task28/task2810/model/HHStrategy.java

    public static void main(String[] args) {
        Provider provider=new Provider(new Strategy() {
        });
        Controller controller=new Controller(provider);
        System.out.println(controller);


    }
}
