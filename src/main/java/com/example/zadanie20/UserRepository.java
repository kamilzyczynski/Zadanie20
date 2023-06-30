package com.example.zadanie20;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("Jan", "Kowalski", 20));
        userList.add(new User("Adrian", "Nowak", 23));
        userList.add(new User("Barbara", "Kreft", 31));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(String firstName, String lastName, int age) {
        userList.add(new User(firstName, lastName, age));
    }
}
