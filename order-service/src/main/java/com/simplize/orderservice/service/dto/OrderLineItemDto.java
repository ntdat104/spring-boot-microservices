package com.simplize.orderservice.service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLineItemDto {

    private Long id;
    
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

}
