package com.simplize.orderservice.util;

import org.springframework.data.domain.Page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponsePage<T> implements Serializable {

    private static Integer OK = 200;

    private static String OK_NAME = "Success";

    private Integer status;
    private String code;
    private String message;
    private Long total;
    private List<T> data;

    public ResponsePage() {
    }

    public ResponsePage(int status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponsePage(int status, String message, List<T> data, Long total) {
        this.status = status;
        this.message = message;
        this.total = total;
        this.data = data;
    }

    public ResponsePage(int status, String message, List<T> data, String beforeToken, String nextToken,
            Integer beforeCount, Integer nextCount) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponsePage<T> data(List<T> data) {
        return new ResponsePage<>(OK, OK_NAME, data);
    }

    public static <T> ResponsePage<T> data(List<T> data, Long total) {
        return new ResponsePage<>(OK, OK_NAME, data, total);
    }

    public static <T> ResponsePage<T> data(List<T> data, String beforeToken, String nextToken, Integer beforeCount,
            Integer nextCount) {
        return new ResponsePage<>(OK, OK_NAME, data, beforeToken, nextToken, beforeCount, nextCount);
    }

    public static <T> ResponsePage<T> data(Page<T> data) {
        return new ResponsePage<>(OK, OK_NAME, data.getContent(), data.getTotalElements());
    }

}
