package com.example.controller;


import com.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    @GetMapping("/createOrder")
    public String createOrder() {
        return orderService.createOrder();
    }
}
