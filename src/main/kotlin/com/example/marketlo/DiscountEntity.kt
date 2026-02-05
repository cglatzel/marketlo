package com.example.marketlo

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "discount")
class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var rate: BigDecimal? = null

    constructor(rate: BigDecimal) {
        this.rate = rate
    }
}