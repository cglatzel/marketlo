package com.example.marketlo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController(
    private val productService: ProductService
) {

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return productService.retrieveAllProducts()
    }

}