package com.fkadu.rest.webservices.rest_web_servises.helloWorld;

public class HelloWorldBeen {

    private String message;

    public HelloWorldBeen(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBeen{" +
                "message='" + message + '\'' +
                '}';
    }
}
