package com.example.marketlo

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun retrieveAllProducts(): List<Product> {
        return productRepository.findAll()
            .map { entity -> Product(entity.name, entity.price, entity.discountEntity?.let { Discount(it.rate) }) }
            .toList()
    }

    fun checkoutShoppingCart(products: List<Product>): CheckoutResult {
        val totalPrice = products.sumOf { product ->
            val p = product.price ?: BigDecimal.ZERO
            val q = product.quantity?.toBigDecimal() ?: BigDecimal.ONE
            val d = product.discount?.rate ?: BigDecimal.ZERO

            p * q * (BigDecimal.ONE - d)
        }
        return CheckoutResult(totalPrice.setScale(2, RoundingMode.HALF_UP), products)
    }
}