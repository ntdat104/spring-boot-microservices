package com.simplize.orderservice.service.converter;

import com.simplize.orderservice.model.Order;
import com.simplize.orderservice.service.dto.OrderDto;
import com.simplize.orderservice.service.form.OrderCreate;

public interface IOrderConverter {

    OrderDto convert(Order model, OrderDto dto);

    Order convert(OrderCreate create, Order model);

}
