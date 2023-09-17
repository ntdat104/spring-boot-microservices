package com.simplize.orderservice.service.converter.impl;

import org.springframework.stereotype.Component;

import com.simplize.orderservice.model.Order;
import com.simplize.orderservice.model.OrderLineItem;
import com.simplize.orderservice.service.converter.IOrderConverter;
import com.simplize.orderservice.service.dto.OrderDto;
import com.simplize.orderservice.service.dto.OrderLineItemDto;
import com.simplize.orderservice.service.form.OrderCreate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderConverter implements IOrderConverter {

    private final OrderLineItemConverter orderLineItemConverter;

    @Override
    public OrderDto convert(Order model, OrderDto dto) {
        dto.setId(model.getId());
        dto.setOrderLineItemDtos(model.getOrderLineItems().stream()
                .map((entity) -> orderLineItemConverter.convert(entity, new OrderLineItemDto())).toList());
        dto.setOrderNumber(model.getOrderNumber());
        return dto;
    }

    @Override
    public Order convert(OrderCreate create, Order model) {
        model.setOrderLineItems(create.getOrderLineItemDtos().stream().map((entity) -> {
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setPrice(entity.getPrice());
            orderLineItem.setQuantity(entity.getQuantity());
            orderLineItem.setSkuCode(entity.getSkuCode());
            return orderLineItem;
        }).toList());

        return model;
    }

}
