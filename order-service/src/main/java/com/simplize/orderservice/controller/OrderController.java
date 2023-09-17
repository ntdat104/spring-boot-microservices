package com.simplize.orderservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.orderservice.service.form.OrderCreate;
import com.simplize.orderservice.service.impl.OrderService;
import com.simplize.orderservice.util.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public Response<?> postMethodName(@RequestBody OrderCreate create) {
        return Response.data(orderService.create(create));
    }

}
