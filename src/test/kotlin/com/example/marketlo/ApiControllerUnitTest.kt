package com.example.marketlo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.math.BigDecimal

class ApiControllerUnitTest {

    @Test
    fun should_get_all_products() {
        // arrange
        val productServiceMock = Mockito.mock(ProductService::class.java)
        val apiController = ApiController(productServiceMock)
        val givenProductEntities = listOf(
            Product("Apple", BigDecimal.valueOf(0.30), null),
            Product("Banana", BigDecimal.valueOf(0.40), null)
        )
        `when`(productServiceMock.retrieveAllProducts()).thenReturn(givenProductEntities)

        // act
        val actualProducts = apiController.getProducts()

        // assert
        assertThat(actualProducts).usingRecursiveFieldByFieldElementComparator().isEqualTo(givenProductEntities)
    }

}