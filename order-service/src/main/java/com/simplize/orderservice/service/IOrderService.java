package com.simplize.orderservice.service;

import com.simplize.orderservice.service.dto.OrderDto;
import com.simplize.orderservice.service.form.OrderCreate;

public interface IOrderService {

    OrderDto create(OrderCreate create);

}
