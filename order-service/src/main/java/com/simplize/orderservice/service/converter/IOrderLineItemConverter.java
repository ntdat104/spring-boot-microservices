package com.simplize.orderservice.service.converter;

import com.simplize.orderservice.model.OrderLineItem;
import com.simplize.orderservice.service.dto.OrderLineItemDto;

public interface IOrderLineItemConverter {

    OrderLineItemDto convert(OrderLineItem model, OrderLineItemDto dto);
    
}
