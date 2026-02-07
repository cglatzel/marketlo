package com.example.marketlo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.validation.support.BindingAwareModelMap

class PageControllerUnitTest {

    @Test
    fun should_load_a_page_with_products() {
        // arrange
        val productServiceMock = Mockito.mock(ProductService::class.java)
        val pageController = PageController(productServiceMock)
        val model = BindingAwareModelMap()

        // act
        val actual = pageController.getProducts(model)

        // assert
        assertThat(actual).isEqualTo("index")
        verify(productServiceMock, times(1)).retrieveAllProducts()
    }

}