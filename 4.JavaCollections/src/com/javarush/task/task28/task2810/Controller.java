package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Provider [] providers;

    public Controller(Provider ... providers) {
        try {

            this.providers = providers;

            if (providers == null || providers.length == 0)
                throw new IllegalArgumentException();
        }catch (NullPointerException e){
            return;
        }
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            int total = 0;
            if (providers == null)
                System.out.println("Hello");

            for (Provider provider : providers) {
                List<Vacancy> vacancy = provider.getJavaVacancies("java");
                total += vacancy.size();
            }
            System.out.println(total);
        } catch (NullPointerException e) {
            return;
        }
    }
}
