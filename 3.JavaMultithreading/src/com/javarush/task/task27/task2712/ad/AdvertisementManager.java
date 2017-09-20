package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {

    private int timeSeconds;

    private AdvertisementStorage storage =AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds=timeSeconds;
    }

  /*  public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> availableVideos = storage.list();
        if (availableVideos.isEmpty()) {
            throw new NoVideoAvailableException();
        }


        Collections.sort(availableVideos, new Comparator<Advertisement>() {
            @Override
           public int compare(Advertisement o1, Advertisement o2) {
                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (pricePerVideoDiff != 0) {
                    return (int) pricePerVideoDiff;
                }else{
                    return (int)(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
           }
       });



    }*/

    public void processVideos() {
        if(storage.list().isEmpty())
            throw new NoVideoAvailableException();
    }
}
