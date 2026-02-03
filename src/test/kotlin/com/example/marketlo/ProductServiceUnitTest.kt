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
        val productService = ProductService();
        val givenProducts = listOf(
            Product("Apple", BigDecimal.valueOf(0.30)),
            Product("Banana", BigDecimal.valueOf(0.40))
        )

        // act
        val actualProducts = productService.retrieveAllProducts();

        // assert
        assertThat(actualProducts).containsAll(givenProducts)
    }
}