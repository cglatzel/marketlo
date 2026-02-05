package com.example.marketlo

import java.math.BigDecimal

data class CheckoutResult(val totalPrice: BigDecimal?, val products: List<Product>?)
