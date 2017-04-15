package com.javarush.task.task14.task1408;

/**
 * Created by script972 on 25.02.2017.
 */
public class BelarusianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+ Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
