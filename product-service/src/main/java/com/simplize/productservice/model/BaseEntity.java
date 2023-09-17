package com.simplize.productservice.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @CreatedBy
    @Field(name = "created_by")
    private Long createdBy;

    @CreatedDate
    @Field(name = "created_date")
    private Date createdDate;

    @LastModifiedBy
    @Field(name = "modified_by")
    private Long modifiedBy;

    @LastModifiedDate
    @Field(name = "modified_date")
    private Date modifiedDate;

}
