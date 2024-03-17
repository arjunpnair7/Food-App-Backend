package com.example.demo.Model;

import java.util.*;

public class Party {
    List<String> users = new ArrayList<String>();
    private int counter;

    Set<Restaurant> filteredList = new HashSet<>();
    Map<String, Restaurant> idToRoomMap = new HashMap<>();


    public Party() {}

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Set<Restaurant> getFilteredList() {
        return filteredList;
    }

    public Map<String, Restaurant> getIdToRoomMap() {
        return idToRoomMap;
    }

    public Party(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
