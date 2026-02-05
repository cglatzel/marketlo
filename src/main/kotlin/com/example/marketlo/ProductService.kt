package com.example.marketlo

import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun retrieveAllProducts(): List<ProductEntity> {
        return productRepository.findAll();
    }
}