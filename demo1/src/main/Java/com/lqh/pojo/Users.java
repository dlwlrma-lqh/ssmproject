package com.lqh.pojo;

import java.util.Date;

public class Users {
    private Integer id;
    private Integer age;
    private String uname;

    private String psd;
    private Date cdate;
    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", age=" + age +
                ", uname='" + uname + '\'' +
                ", psd='" + psd + '\'' +
                ", cdate=" + cdate +
                ", money=" + money +
                '}';
    }
}
