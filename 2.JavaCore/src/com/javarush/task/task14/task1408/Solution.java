package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if(Country.RUSSIA==country)
                hen=new RussianHen();
            if(Country.UKRAINE==country)
                hen=new UkrainianHen();
            if(Country.MOLDOVA==country)
                hen=new MoldovanHen();
            if(Country.BELARUS==country)
                hen=new BelarusianHen();
            return hen;
        }
    }


}
