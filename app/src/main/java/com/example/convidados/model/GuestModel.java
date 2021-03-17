package com.example.convidados.model;

public class GuestModel {

    private int id;
    private String name;
    private int confirmation;

    public GuestModel(String name, int confirmation) {
        this.id = 0;
        this.name = name;
        this.confirmation = confirmation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
}
