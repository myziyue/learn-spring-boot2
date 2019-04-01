package com.myziyue.learn.ch10.ch10rest.controller;

import com.myziyue.learn.ch10.ch10rest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/test")
public class ClientController {
    @Value(value = "${api.order}")
    String base;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/get/{orderId}")
    @ResponseBody
    public Order testGetOrder(@PathVariable String orderId) throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";
        // 核心代码
        Order order = client.getForObject(uri, Order.class, orderId);
        return order;
    }

    @GetMapping("/addorder")
    @ResponseBody
    public String testAddOrder() throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order";
        Order order = new Order();
        order.setName("test");
        String ret = client.postForObject(uri, order, String.class);
        return ret;
    }
}
