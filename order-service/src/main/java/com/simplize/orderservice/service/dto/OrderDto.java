package com.simplize.orderservice.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDto {

    private Long id;

    private String orderNumber;

    private List<OrderLineItemDto> orderLineItemDtos;

}
