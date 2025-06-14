package com.lab03.lab03.utils;

public record Response(String status, String message) {
    public Response(String message) {
        this("success", message);
    }
}