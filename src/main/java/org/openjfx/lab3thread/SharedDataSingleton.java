package org.openjfx.lab3thread;

import java.util.ArrayList;


public class SharedDataSingleton {
    private static SharedDataSingleton instance;
    private static ArrayList<User> activeUsers ;

    private SharedDataSingleton() {
        activeUsers = new ArrayList<User>();
    }

    public static SharedDataSingleton getInstance() {
        if (instance == null) {
            instance = new SharedDataSingleton();
        }
        return instance;
    }

    public ArrayList<User> getActiveUsers() {
        return activeUsers;
    }
    public void setActiveUsers(String path) {
        SharedDataSingleton.activeUsers = User.scanUsersFromFile(path);
    }

}