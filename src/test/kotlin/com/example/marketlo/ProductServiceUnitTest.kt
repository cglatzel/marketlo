package com.example.marketlo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.math.BigDecimal

class ProductServiceUnitTest {

    @Test
    fun should_get_all_products() {
        // arrange
        val productRepository = Mockito.mock(ProductRepository::class.java)
        val productService = ProductService(productRepository)
        val givenProductEntities = listOf(
            ProductEntity("Apple", BigDecimal.valueOf(0.30), DiscountEntity(BigDecimal.valueOf(0.25))),
            ProductEntity("Banana", BigDecimal.valueOf(0.40), null)
        )
        `when`(productRepository.findAll()).thenReturn(givenProductEntities)

        // act
        val actualProducts = productService.retrieveAllProducts()

        // assert
        val expectedProducts = listOf(
            Product("Apple", BigDecimal.valueOf(0.30), Discount(BigDecimal.valueOf(0.25))),
            Product("Banana", BigDecimal.valueOf(0.40), null),
        )
        assertThat(actualProducts).usingRecursiveFieldByFieldElementComparator().isEqualTo(expectedProducts)
    }

    @Test
    fun should_checkout_and_apply_discount() {
        // arrange
        val productRepository = Mockito.mock(ProductRepository::class.java)
        val productService = ProductService(productRepository)
        val givenProducts = listOf(
            Product("Apple", BigDecimal.valueOf(0.30), Discount(BigDecimal.valueOf(0.25)), 2),
            Product("Banana", BigDecimal.valueOf(0.40), null, 1),
        )

        // act
        val (totalPrice, products) = productService.checkoutShoppingCart(givenProducts)

        // assert
        val expectedPrice = BigDecimal.valueOf(0.85)
        assertThat(totalPrice).isEqualTo(expectedPrice)
        assertThat(products).usingRecursiveFieldByFieldElementComparator().isEqualTo(givenProducts)
    }
}