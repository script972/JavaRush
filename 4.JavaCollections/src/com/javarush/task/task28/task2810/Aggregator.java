package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.vo.Vacancy;

public class Aggregator  {
//    https://github.com/mrShahid/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task28/task2810/model/HHStrategy.java

    public static void main(String[] args) {
        Provider hhProvider = new Provider(new HHStrategy());
        Controller controller=new Controller(hhProvider);
        controller.scan();



    }
}
