package com.zbhg.mcp.pointofsale.exceptions;

public class MainControllerNotFound extends Exception {

    String message;
    public MainControllerNotFound() {
        setMessage();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage() {
        this.message = "Main Controller Class Not Found Error";
    }
}
