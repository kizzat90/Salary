package com.salary.app.util;

import org.springframework.http.HttpStatus;

public class CustomErrorMessage extends Exception {
    private String message;
    private String error;
    private HttpStatus status;

    public CustomErrorMessage(HttpStatus status, String message, String error) {
        super();
        this.message = message;
        this.error = error;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public StackTraceElement[] getStackTrace() { return null; }
}
