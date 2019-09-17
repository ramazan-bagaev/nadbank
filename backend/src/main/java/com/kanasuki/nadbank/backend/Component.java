package com.kanasuki.nadbank.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Component {

    @RequestMapping("/greeting")
    public String index() {
        return "greeting";

    }
}
