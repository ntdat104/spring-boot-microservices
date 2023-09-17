package com.simplize.orderservice.service.converter.impl;

import org.springframework.stereotype.Component;

import com.simplize.orderservice.model.OrderLineItem;
import com.simplize.orderservice.service.converter.IOrderLineItemConverter;
import com.simplize.orderservice.service.dto.OrderLineItemDto;

@Component
public class OrderLineItemConverter implements IOrderLineItemConverter {

    @Override
    public OrderLineItemDto convert(OrderLineItem model, OrderLineItemDto dto) {
        dto.setId(model.getId());
        dto.setPrice(model.getPrice());
        dto.setQuantity(model.getQuantity());
        dto.setSkuCode(model.getSkuCode());
        return dto;
    }

}
