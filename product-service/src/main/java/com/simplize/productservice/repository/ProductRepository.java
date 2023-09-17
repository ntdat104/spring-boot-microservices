package com.simplize.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.simplize.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
