package com.example.marketlo

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "discount")
class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var value: BigDecimal? = null

    constructor(value: BigDecimal) {
        this.value = value
    }
}