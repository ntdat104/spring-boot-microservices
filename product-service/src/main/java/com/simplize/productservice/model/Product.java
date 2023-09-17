package com.simplize.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(value = "product")
public class Product extends BaseEntity {

    @Field(name = "title")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "price")
    private BigDecimal price;

}
