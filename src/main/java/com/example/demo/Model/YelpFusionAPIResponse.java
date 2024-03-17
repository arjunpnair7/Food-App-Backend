package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class YelpFusionAPIResponse {

    private List<Restaurant> businesses;

}
