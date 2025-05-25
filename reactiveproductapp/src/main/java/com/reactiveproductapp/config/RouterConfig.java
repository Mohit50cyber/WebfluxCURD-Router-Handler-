package com.reactiveproductapp.config;

import com.reactiveproductapp.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(ProductHandler productHandler){
        return RouterFunctions.route()
                .GET("/products",productHandler::getAll)
                .GET("/products.{id}",productHandler::getById)
                .POST("/products",productHandler::create)
                .DELETE("/products/{id}",productHandler::delete)
                .build();
    }
}
