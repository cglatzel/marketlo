package com.example.marketlo

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun retrieveAllProducts(): List<Product> {
        return productRepository.findAll()
            .map { entity -> Product(entity.name, entity.price, entity.discountEntity?.let { Discount(it.rate) }) }
            .toList()
    }

    fun checkoutShoppingCart(products: List<Product>): CheckoutResult {
        val totalPrice = products.map {
            it.price?.multiply(
                it.quantity?.toBigDecimal()?.multiply(it.discount?.rate?.add(BigDecimal.valueOf(-1)))
            )
        }.reduce { acc, currentPrice -> acc?.add(currentPrice) }
        return CheckoutResult(totalPrice, emptyList())
    }
}