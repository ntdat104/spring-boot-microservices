package com.simplize.orderservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplize.orderservice.model.Order;
import com.simplize.orderservice.model.OrderLineItem;
import com.simplize.orderservice.repository.OrderRepository;
import com.simplize.orderservice.service.IOrderService;
import com.simplize.orderservice.service.converter.impl.OrderConverter;
import com.simplize.orderservice.service.dto.OrderDto;
import com.simplize.orderservice.service.form.OrderCreate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService implements IOrderService {

    private final OrderConverter orderConverter;

    private final OrderRepository orderRepository;

    @Override
    public OrderDto create(OrderCreate create) {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = create.getOrderLineItemDtos().stream().map((entity) -> {
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setOrder(order);
            orderLineItem.setPrice(entity.getPrice());
            orderLineItem.setQuantity(entity.getQuantity());
            orderLineItem.setSkuCode(entity.getSkuCode());
            return orderLineItem;
        }).toList();

        order.setOrderLineItems(orderLineItems);

        Order orderSaved = orderRepository.save(order);

        OrderDto orderDto = orderConverter.convert(orderSaved, new OrderDto());

        return orderDto;
    }

}
