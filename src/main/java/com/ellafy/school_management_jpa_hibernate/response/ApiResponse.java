package com.ellafy.school_management_jpa_hibernate.response;

public class ApiResponse<T>{
    private int status;

    private String message;

    private long timeStamp;

    private T data;

    public ApiResponse(){}

    public ApiResponse(int status, String message, long timeStamp, T data) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
