package com.zonew.myprojactaffterupdate;

public class Member {
    private int id;
    private String name;
    private String phoneNumber;

    Member(String name, String phno) {
        this.name = name;
        this.phoneNumber = phno;
    }

    Member(int id, String name, String phno) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phno;
    }

    int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String getPhno() {
        return phoneNumber;
    }
    public void setPhno(String phno) {
        this.phoneNumber = phno;
    }
}
