package com.reactiveproductapp.controller;

import com.reactiveproductapp.entity.ProductSB;
import com.reactiveproductapp.service.ProductSBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductSBController {

    private final ProductSBService productSBService;

    @GetMapping
    public ResponseEntity<List<ProductSB>> getAllProducts(){
        List<ProductSB> productSBList = productSBService.getAllProducts();
        return ResponseEntity.ok(productSBList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductSB> getProductsById(@PathVariable Long id){
        ProductSB productSB = productSBService.getProductById(id);
        return ResponseEntity.ok(productSB);
    }

    @PostMapping
    public ResponseEntity<ProductSB> createProduct(@RequestBody ProductSB productSB){
        ProductSB saveProduct = productSBService.createProduct(productSB);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productSBService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }




}
