package com.example.marketlo

import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    private val productService: ProductService
) {

    fun getProducts(): List<Product> {
        return productService.retrieveAllProducts();
    }

}