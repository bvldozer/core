package com.cartenz.core.api;


import com.google.gson.JsonArray;

public class BaseApiDao<T> {
    private T data;
    private int code;
    private String message;
    private JsonArray error;

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public JsonArray getError() {
        return error;
    }
}
