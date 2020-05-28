package com.crm.dao;

public class Leave {
   private int id;
   private String from_number;
   private String to_number;
   private String from_id;
   private String to_id;
   private String content;
   private String time;
   private int state;
   private String back;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_number() {
        return from_number;
    }

    public void setFrom_number(String from_number) {
        this.from_number = from_number;
    }

    public String getTo_number() {
        return to_number;
    }

    public void setTo_number(String to_number) {
        this.to_number = to_number;
    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    @Override
    public String toString() {
        return "Leave [ id=" + id
                +", from_number=" + from_number + ", to_number=" + to_number + ", from_id=" +from_id+", to_id=" + to_id+", " +
                "content=" + content+", time=" + time+",state=" + state+", back=" + back+"]";
    }

}
