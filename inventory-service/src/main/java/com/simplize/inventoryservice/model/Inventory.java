package com.simplize.inventoryservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_inventory", indexes = {
        @Index(name = "idx_inventory_sku_code", columnList = "sku_code")
})
public class Inventory extends BaseEntity {

    @Column(name = "sku_code", nullable = false)
    private String skuCode;

    @Column(name = "quantity")
    private Integer quantity;

}
