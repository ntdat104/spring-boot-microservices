package com.simplize.productservice.service.form;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductUpdate {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;

}
