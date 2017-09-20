package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class Tablet extends Observable{
    final int number;
    public static Logger logger=Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order;
        try {
            order = new Order(this);

            if(!order.isEmpty()){
                setChanged();
                notifyObservers(order);
                System.out.println(order.toString());
                try {
                   new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
                } catch (NoVideoAvailableException e) {
                  logger.log(Level.INFO, "No video is available for the order" + order);
                }
            }
        }catch (IOException e){
            logger.log(SEVERE, "Console is unavailable.");
            return null;
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
