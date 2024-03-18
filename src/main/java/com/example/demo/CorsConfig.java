package com.example.demo;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

//    @Bean
//    public CorsFilter corsFilter() {
//        System.out.println("CORS FILTER");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*"); // Allow requests from any origin
//        config.addAllowedMethod("*");
//        config.addAllowedHeader("*");
//        config.setAllowCredentials(true);
//        config.addExposedHeader("Access-Control-Allow-Origin");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}


