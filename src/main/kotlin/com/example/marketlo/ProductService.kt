package com.example.marketlo

import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun retrieveAllProducts(): List<Product> {
        return productRepository.findAll()
            .map { entity -> Product(entity.name, entity.price, entity.discountEntity?.let { Discount(it.rate) }) }
            .toList()
    }

    fun checkoutShoppingCart(products: List<Product>): CheckoutResult {
        return CheckoutResult(null, emptyList())
    }
}