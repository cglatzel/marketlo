package com.example.marketlo

import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun retrieveAllProducts(): List<Product> {
        // return productRepository.findAll();
        return listOf();
    }
}