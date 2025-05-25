package com.reactiveproductapp.service;

import com.reactiveproductapp.entity.ProductSB;
import com.reactiveproductapp.exception.ProductSBNotFoundException;
import com.reactiveproductapp.repository.ProductSBRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSBService {

    private final ProductSBRepo productSBRepo;

    public List<ProductSB> getAllProducts(){
        return productSBRepo.findAll();
    }

    public ProductSB getProductById(Long id){
        return productSBRepo.findById(id)
                .orElseThrow(()-> new ProductSBNotFoundException("Product  not found " + id));
    }

    public ProductSB createProduct(ProductSB productSB){
        return productSBRepo.save(productSB);
    }


    public void deleteProduct(Long id){
        ProductSB productSB = new ProductSB();
        productSBRepo.delete(productSB);
    }













}
