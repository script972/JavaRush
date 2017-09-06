package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by script972 on 16.07.2017.
 */
public class UsersView implements View {
    
    private Controller controller;
    
    @Override
    public void refresh(ModelData modelData) {

        System.out.println("All users:");
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t"+modelData.getUsers().get(i));
        }
        System.out.println("===================================================");


    }


    public void fireEventShowDeletedUsers() {
              controller.onShowAllDeletedUsers();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();

    }
}
