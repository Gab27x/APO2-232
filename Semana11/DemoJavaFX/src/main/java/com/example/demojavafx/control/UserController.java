package com.example.demojavafx.control;

import com.example.demojavafx.model.User;

import java.util.ArrayList;

public class UserController {

    private ArrayList<User> users;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(String name, String id, int years){
        User user = new User(name, id, years);
        users.add(user);
    }

    public String printUsers(){
        String msj = "";
        for (int i = 0; i < users.size(); i++) {
            msj += users.get(i) + "\n";
        }
        return msj;
    }
}
