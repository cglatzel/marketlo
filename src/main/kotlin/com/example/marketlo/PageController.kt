package com.example.marketlo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController(
    val productService: ProductService
) {

    @GetMapping("/")
    fun getProducts(model: Model): String {
        model.set("products", productService.retrieveAllProducts())
        return "index"
    }

}