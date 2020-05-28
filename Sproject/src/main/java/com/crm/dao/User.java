package com.crm.dao;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class User {
    private int id;
    private String name;
    private String number;
    private String password;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number+ '\''  +
                ", password='" + password+
                '}';
    }

}
