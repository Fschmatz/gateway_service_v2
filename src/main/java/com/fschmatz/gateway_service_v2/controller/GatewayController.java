package com.fschmatz.gateway_service_v2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
//@RequestMapping("/gateway")
public class GatewayController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/homeTeste")
    public String homePageTeste() {
        return "homeTeste";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}