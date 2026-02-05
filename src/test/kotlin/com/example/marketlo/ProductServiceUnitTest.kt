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
        val productService = ProductService(productRepository);
        val givenProductEntities = listOf(
            ProductEntity("Apple", BigDecimal.valueOf(0.30)),
            ProductEntity("Banana", BigDecimal.valueOf(0.40))
        )
        `when`(productRepository.findAll()).thenReturn(givenProductEntities)

        // act
        val actualProducts = productService.retrieveAllProducts();

        // assert
        assertThat(actualProducts).usingRecursiveFieldByFieldElementComparator().containsAll(givenProductEntities)
    }
}