package com.simplize.orderservice.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.simplize.orderservice.model.Order;
import com.simplize.orderservice.repository.OrderRepository;
import com.simplize.orderservice.service.IOrderService;
import com.simplize.orderservice.service.converter.impl.OrderConverter;
import com.simplize.orderservice.service.dto.OrderDto;
import com.simplize.orderservice.service.form.OrderCreate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {

    private final OrderConverter orderConverter;

    private final OrderRepository orderRepository;

    @Override
    public OrderDto create(OrderCreate create) {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        Order orderConverted = orderConverter.convert(create, order);

        Order orderSaved = orderRepository.save(orderConverted);

        OrderDto orderDto = orderConverter.convert(orderSaved, new OrderDto());

        return orderDto;
    }

}
