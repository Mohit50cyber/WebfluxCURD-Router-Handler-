package com.reactiveproductapp.handler;

import com.reactiveproductapp.dto.ProductDTO;
import com.reactiveproductapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private  ProductService productService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return ServerResponse.ok().body(productService.getAllProducts(), ProductDTO.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return productService.getSingleProdById(id)
                .flatMap(product->ServerResponse.ok().bodyValue(product));
    }


    public Mono<ServerResponse> create(ServerRequest serverRequest){
        return serverRequest.bodyToMono(ProductDTO.class)
                .flatMap(productService::createProduct)
                .flatMap(product->ServerResponse.status(HttpStatus.CREATED).bodyValue(product));
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest){
        return productService.deleteProduct(serverRequest.pathVariable("id"))
                .then(ServerResponse.noContent().build());
    }
















}
