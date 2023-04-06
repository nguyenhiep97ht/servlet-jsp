package com.example.javaeedemo.model;

public class Physician {

    String name;
    String position;
    int ssn;

    long id;

    public Physician() {

    }
    public Physician(String name, String position, int ssn, long id) {
        this.name = name;
        this.position = position;
        this.ssn = ssn;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
