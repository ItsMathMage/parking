package com.utm.exception;

public class ServiceExceptionDTO extends RuntimeException {
    private int code;
    private String message;
    private String details;

    public ServiceExceptionDTO() {}

    public ServiceExceptionDTO(final ServiceException e) {
        this.code = e.getCode();
        this.message = e.getMessage();
        this.details = e.getDetails();
    }

    public ServiceExceptionDTO(final int code, final String message, final String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

