package com.crm.dao;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class Maintain {
    private int id;
    private String xi;
    private String clas;
    private String lnub;
    private String snub;
    private String name;
    private String phone;
    private String state;
    private String time;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String content;

    public String getXi() {
        return xi;
    }

    public void setXi(String xi) {
        this.xi = xi;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getLnub() {
        return lnub;
    }

    public void setLnub(String lnub) {
        this.lnub = lnub;
    }

    public String getSnub() {
        return snub;
    }

    public void setSnub(String snub) {
        this.snub = snub;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Maintain [ id=" + id
                +", xi=" + xi + ", clas=" + clas + ", lnub=" + lnub+", snub=" + snub+", " +
                "name=" + name+", phone=" + phone+", content=" +content+", state=" +state
                + ", time=" +time+"]";
    }
}
