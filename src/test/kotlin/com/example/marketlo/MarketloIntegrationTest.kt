package com.example.marketlo

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.client.RestTestClient
import java.math.BigDecimal

@SpringBootTest
@AutoConfigureRestTestClient
class MarketloIntegrationTest(@Autowired private val restTestClient: RestTestClient) {

    @Autowired
    val productRepository: ProductRepository? = null

    @BeforeEach
    fun beforeEach() {
        val product = ProductEntity("Apple", BigDecimal.valueOf(0.30), null);
        productRepository?.save(product);
    }

    @Test
    fun should_retrieve_products_from_the_api() {
        // arrange

        // act
        val returnResult = restTestClient.get().uri("/api/products").exchange().expectStatus().isOk().returnResult();

        // assert
        Assertions.assertThat(returnResult).isExactlyInstanceOf(String.Companion::class.java)
    }

}