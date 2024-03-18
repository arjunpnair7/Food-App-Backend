package com.example.demo;

import com.example.demo.Model.Restaurant;
import com.example.demo.Model.YelpFusionAPIResponse;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import feign.Param;
import feign.RequestLine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yelpApiClient", url = "https://api.yelp.com/v3")
public interface YelpApiClient {
    @GetMapping("/businesses/search")
    YelpFusionAPIResponse searchBusinesses(@RequestParam("latitude") double latitude,
                                           @RequestParam("longitude") double longitude,
                                           @RequestParam("limit") int limit,
                                           @RequestHeader("Authorization") String authorization);

    @GetMapping("/businesses/search")
    YelpFusionAPIResponse searchBusinessesTest(@RequestParam("location") String location,
                                           @RequestParam("limit") int limit,
                                           @RequestHeader("Authorization") String authorization);
}



//@FeignClient(name = "yelpfusion")
//public interface YelpFusionProxy {
//    @RequestLine("GET /businesses/search?location={location}&sort_by={sortBy}&limit={limit}")
//    String searchBusinesses(@Param("location") String location,
//                                     @Param("sortBy") String sortBy,
//                                     @Param("limit") int limit);
//}
