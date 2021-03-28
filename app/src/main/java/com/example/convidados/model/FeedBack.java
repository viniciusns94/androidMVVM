package com.example.convidados.model;

public class FeedBack {

    private boolean mSuccess = true;
    private final String mMessage;

    public FeedBack(String message) {
        this.mMessage = message;
    }

    public FeedBack(String message, boolean success) {
        this.mMessage = message;
        this.mSuccess = success;
    }

    public boolean ismSuccess(){
        return this.mSuccess;
    }

    public String getMessage(){
        return this.mMessage;
    }
}
