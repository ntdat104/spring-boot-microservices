package com.simplize.orderservice.service.form;

import java.util.List;

import com.simplize.orderservice.service.dto.OrderLineItemDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderCreate {

    private List<OrderLineItemDto> orderLineItemDtos;

}
