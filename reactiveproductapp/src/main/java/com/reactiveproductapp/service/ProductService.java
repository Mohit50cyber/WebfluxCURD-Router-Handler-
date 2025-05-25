package com.reactiveproductapp.service;

import com.reactiveproductapp.dto.ProductDTO;
import com.reactiveproductapp.exception.ProductNotFoundException;
import com.reactiveproductapp.mapper.ProductMapper;
import com.reactiveproductapp.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public Flux<ProductDTO> getAllProducts(){
        return productRepo.findAll().map(productMapper::toDTO);
    }

    public Mono<ProductDTO> getSingleProdById(String id){
        return productRepo.findById(id)
                .map(productMapper::toDTO)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found")));
    }

    public Mono<ProductDTO> createProduct(ProductDTO productDTO){
        return productRepo.save(productMapper.toEntity(productDTO)).map(productMapper::toDTO);
    }

    public Mono<Void> deleteProduct(String id){
        return productRepo.findById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found") ))
                .flatMap(productRepo::delete);
    }


}
