package com.store.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorseSecurity {

    //autorise le front à accéder à l'API
    // # faille XSS
    @Bean
    public WebMvcConfigurer configCorsPolicy(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry){
                corsRegistry.addMapping("/**")
                            .allowedOrigins("*")
                            .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }

        };
    }
    
}
