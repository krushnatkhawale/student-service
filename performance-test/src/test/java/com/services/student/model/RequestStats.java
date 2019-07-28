package com.services.student.model;


public class RequestStats {
    private String key;
    private int statusCode;
    private long duration;

    public RequestStats(String key, int statusCode, long duration) {
        this.key = key;
        this.statusCode = statusCode;
        this.duration = duration;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}