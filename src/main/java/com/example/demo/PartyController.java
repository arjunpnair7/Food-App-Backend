package com.example.demo;


import com.example.demo.Model.*;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin

public class PartyController {

    private YelpApiClient yelpFusionProxy;

    public PartyController(YelpApiClient yelpFusionProxy) {
        this.yelpFusionProxy = yelpFusionProxy;
    }

    ConcurrentHashMap<String, Party> partySessions = new ConcurrentHashMap<>();
    @GetMapping("/new-party")
    public String createNewParty() {
        boolean uniqueCode = false;
        String code = "";
        while (!uniqueCode) {
            Random random = new Random();
            code = Integer.toString(random.nextInt(900000) + 100000);
            if (!partySessions.containsKey(code)) {
                uniqueCode = true;
            }
        }
        partySessions.put(code, new Party());

        return code;
//        return new WebSocketMessage(WebSocketMessage.MessageType.CODE, code);
    }

    //YelpFusionAPIResponse response = yelpFusionProxy.searchBusinesses(location, sortBy, limit, authorizationHeader);
    //        for (Restaurant restaurant: response.getBusinesses()) {
    //            System.out.println(restaurant.getName());
    //        }

    @MessageMapping("/room/{code}/done-voting")
    @SendTo("/room/{code}")
    public WebSocketMessage doneVoting(@DestinationVariable String code, List<Restaurant> filteredIdList) {
//        System.out.println("DONE-VOTING");
        Party curParty = partySessions.get(code);
        Set<Restaurant> filteredRestaurantSet = curParty.getFilteredList();
        for (Restaurant cur: filteredIdList) {
            String id = cur.getId();
            Restaurant curRestaurant = curParty.getIdToRoomMap().get(id);
            filteredRestaurantSet.add(curRestaurant);
        }
        curParty.setCounter(curParty.getCounter() + 1);
        if (curParty.getCounter() == curParty.getUsers().size()) {
            System.out.println("DONE VOTING");
            List<Restaurant> filteredRestaurantList = new ArrayList<>(filteredRestaurantSet);
            return new WebSocketMessage(WebSocketMessage.MessageType.DONE_VOTING, filteredRestaurantList);
        } else {
            System.out.println("NOT DONE VOTING");
            return new WebSocketMessage(WebSocketMessage.MessageType.NOT_DONE, "Not done");
        }

    }


    @MessageMapping("/room/{code}/get-data")
    @SendTo("/room/{code}")
    public WebSocketMessage getData(@DestinationVariable String code, Coordinates location) {
        System.out.println("GET DATA");
        String authorizationHeader = "Bearer " + "BxEPFYszd5A3EVItnV8d-2z3LXTUIblvhZZacuW9OBjPcy8R6YaPyPFev1rKoGhzofRYaAw6sasSe7qu255hAnps62AO1AECjPHMcE7J7zmnI8wYxv-UZCUPlCLqZXYx";
        YelpFusionAPIResponse response = yelpFusionProxy.searchBusinesses(location.getLatitude(), location.getLongitude(), 20, authorizationHeader);

        System.out.println("LATITUDE: " + location.getLatitude());
        System.out.println("LONGITUDE: " + location.getLongitude());

        Party curParty = partySessions.get(code);
        for (Restaurant restaurant: response.getBusinesses()) {
            curParty.getIdToRoomMap().put(restaurant.getId(), restaurant);
        }

        return new WebSocketMessage(WebSocketMessage.MessageType.DATA, response);
    }


    @MessageMapping("/room/{code}/add-user")
    @SendTo("/room/{code}")
    public WebSocketMessage addUser(@DestinationVariable String code, String username) {
        String location = "Naperville";
        String sortBy = "best_match";
        int limit = 20;
        String authorizationHeader = "Bearer " + "BxEPFYszd5A3EVItnV8d-2z3LXTUIblvhZZacuW9OBjPcy8R6YaPyPFev1rKoGhzofRYaAw6sasSe7qu255hAnps62AO1AECjPHMcE7J7zmnI8wYxv-UZCUPlCLqZXYx";


//        YelpFusionAPIResponse response = yelpFusionProxy.searchBusinesses(location, sortBy, limit, authorizationHeader);
//        for (Restaurant restaurant: response.getBusinesses()) {
//            System.out.println(restaurant.getName());
//        }

        Party curParty = partySessions.get(code);
        if (curParty.getUsers().contains(username)) {
            System.out.println("ALREADY ADDED: " + username);
        } else {
            curParty.getUsers().add(username);
            System.out.println("Added user: " + username);
        }
//        return curParty.getUsers();
        System.out.println("LINE 71: " + curParty.getUsers());
        return new WebSocketMessage(WebSocketMessage.MessageType.USER_LIST, curParty.getUsers());
    }

    @MessageMapping("/room")
    @SendTo("/room")
    public String createParty() {
//        String location = "Naperville";
//        String sortBy = "best_match";
//        int limit = 20;

//        String response = yelpFusionProxy.searchBusinesses(location, sortBy, limit);
//        System.out.println(response);
//        System.out.println("POKEMON: " + yelpFusionProxy.getPokemonList());
//        System.out.println("data: " + yelpFusionProxy.searchBusinesses("Naperville", "best_match", 20));
        boolean uniqueCode = false;
        String code = "";
        while (!uniqueCode) {
            Random random = new Random();
            code = Integer.toString(random.nextInt(900000) + 100000);
            if (!partySessions.containsKey(code)) {
                uniqueCode = true;
            }
        }
        partySessions.put(code, new Party());
        System.out.println("CREATED PARTY: " + code);

        return code;
    }
}
