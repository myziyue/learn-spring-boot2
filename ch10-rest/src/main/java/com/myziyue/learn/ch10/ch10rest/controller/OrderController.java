package com.myziyue.learn.ch10.ch10rest.controller;

import com.myziyue.learn.ch10.ch10rest.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable String orderId) throws Exception {
        Order order = new Order();
        order.setId(orderId);
        order.setName("Demo");
        return order;
    }

    @PostMapping("/order")
    public String addOrder(@RequestBody Order order) throws Exception {
        return "{success: true, message\"Add Order Success\"}";
    }

    @DeleteMapping("/order/{orderId}")
    public String cancelOrder(@PathVariable String orderId) throws Exception {
        return "{success: true, message\"Delete Order Success\"}";
    }
}
