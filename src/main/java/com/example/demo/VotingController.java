package com.example.demo;

import com.example.demo.Model.Party;
import com.example.demo.Model.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;



@RestController
public class VotingController {

    ConcurrentHashMap<String, Party> partySessions = new ConcurrentHashMap<>();






}
