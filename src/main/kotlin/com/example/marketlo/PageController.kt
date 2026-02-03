package com.example.marketlo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController {

    @GetMapping("/")
    fun getProducts(): String {
        return "index";
    }

}