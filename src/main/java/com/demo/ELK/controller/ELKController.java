package com.demo.ELK.controller;

import com.demo.ELK.services.ELKService;
import com.demo.ELK.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class ELKController {

    @Autowired
    ELKService service;

    @Autowired
    RestService restService;

    private static final Logger log = LoggerFactory.getLogger(ELKController.class);

    @GetMapping(value = "/get/hello")
    public String helloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}",response);
        return response;
    }

    @GetMapping(value = "/get/Food-Details")
    public JSONArray foodDetails() {
        log.info("Inside Food Detail Function");
        return service.getAllFoodDetails();
    }

    @GetMapping(value = "get/weather/{city}")
    public JsonNode getWeatherInformation(@PathVariable String city){
        return restService.getPostsPlainJSON(city);
    }
}
