package com.example.demo.Model;

import java.util.*;

public class Party {
    List<String> users = new ArrayList<String>();
    private int counter;

    Set<Restaurant> filteredList = new HashSet<>();
    List<Restaurant> filteredRestaurantList = new ArrayList<>();
    Map<String, Restaurant> idToRoomMap = new HashMap<>();


    public Party() {}

    public List<Restaurant> getFilteredRestaurantList() {
        return filteredRestaurantList;
    }

    public void setFilteredRestaurantList(List<Restaurant> filteredRestaurantList) {
        this.filteredRestaurantList = filteredRestaurantList;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Set<Restaurant> getFilteredList() {
        return filteredList;
    }
    public void setFilteredList(Set<Restaurant> filteredList) {
        this.filteredList = filteredList;
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
