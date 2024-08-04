package com.praveen.springguru.rest_crud_demo.error.pojo;

public class ErrorResponse {

    private int code;
    private String message;
    private long timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message, Long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
