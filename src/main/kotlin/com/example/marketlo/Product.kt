package com.example.marketlo

import java.math.BigDecimal

data class Product(val name: String?, val price: BigDecimal?, val discount: Discount?, val quantity: Int? = 0)