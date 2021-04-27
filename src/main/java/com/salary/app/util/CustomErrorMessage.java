package com.salary.app.util;

public class CustomErrorMessage extends Exception {
    private String message;
    private String error;

    public CustomErrorMessage(String message, String error) {
        super();
        this.message = message;
        this.error = error;
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

    @Override
    public StackTraceElement[] getStackTrace() { return null; }
}
