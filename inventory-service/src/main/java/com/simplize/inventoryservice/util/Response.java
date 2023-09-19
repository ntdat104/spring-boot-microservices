package com.simplize.inventoryservice.util;

import java.io.Serializable;

import lombok.Data;

@Data
public class Response<T> implements Serializable {

    private static Integer BAD_REQUEST = 400;
    private static Integer OK = 200;

    private static String BAD_REQUEST_NAME = "Bad Request";
    private static String OK_NAME = "Success";

    private Integer status;
    private String code;
    private String message;
    private Long total;
    private T data;

    public Response() {
    }

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(int status, String message, String declineCode) {
        this.status = status;
        this.message = message;
        this.code = declineCode;
    }

    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(int status, String message, T data, Long total) {
        this.status = status;
        this.message = message;
        this.total = total;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(OK, OK_NAME);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(OK, msg);
    }

    public static <T> Response<T> fail() {
        return new Response<>(BAD_REQUEST, BAD_REQUEST_NAME);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>(BAD_REQUEST, message);
    }

    public static <T> Response<T> fail(int status, String message) {
        return new Response<>(status, message);
    }

    public static <T> Response<T> fail(int status, String message, String code) {
        return new Response<>(status, message, code);
    }

    public static <T> Response<T> data(T data) {
        return new Response<>(OK, OK_NAME, data);
    }

    public static <T> Response<T> data(T data, int status) {
        return new Response<>(status, status == 200 ? OK_NAME : BAD_REQUEST_NAME, data);
    }

    public static <T> Response<T> data(T data, Long total) {
        return new Response<>(OK, OK_NAME, data, total);
    }

}
