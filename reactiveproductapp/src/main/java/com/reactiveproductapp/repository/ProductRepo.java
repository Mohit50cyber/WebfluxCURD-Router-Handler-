package com.reactiveproductapp.repository;

import com.reactiveproductapp.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepo extends ReactiveMongoRepository<Product,String> {
}
