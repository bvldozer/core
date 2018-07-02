package com.cartenz.core.api;


import java.util.List;

public class BaseApiDao<T> {
    public T data;
    public int code;
    public String message;
    public List<Errors> errors;

    public static class Errors {
        public int code;
        public int itemCode;
    }
}
