package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by script972 on 16.07.2017.
 */
public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));

    }

    public void loadDeletedUsers() {
        //modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

}
