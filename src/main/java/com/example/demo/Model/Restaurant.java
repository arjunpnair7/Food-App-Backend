package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    private String id;
    private String name;
    private String image_url;
    private double rating;
    private String price;
    private double distance;
    private String url;
    private String phone;
}
