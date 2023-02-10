package com.demain.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    /**
     * 接口测试
     */
    @GetMapping("/test")
    public String index() {
        return "index";
    }

}
