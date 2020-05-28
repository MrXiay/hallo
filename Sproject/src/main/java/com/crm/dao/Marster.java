package com.crm.dao;

public class Marster {
    private int id;
    private String name;
    private String phone;
    private String location;

    public int getId() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone+ '\''  +
                ", location='" + location+
                '}';
    }

}
