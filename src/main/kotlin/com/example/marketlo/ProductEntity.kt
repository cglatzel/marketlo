package com.example.marketlo

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "product")
class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null

    var price: BigDecimal? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    var discountEntity: DiscountEntity? = null

    constructor(name: String, price: BigDecimal, discountEntity: DiscountEntity?) {
        this.name = name
        this.price = price
        this.discountEntity = discountEntity
    }

}
