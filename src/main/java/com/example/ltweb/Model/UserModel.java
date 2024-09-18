package com.example.ltweb.Model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    public UserModel(){}
    public UserModel(String phone, String roldid, String image, String gender, Date createDate, String password, String email, String fullname, String username, int id) {
        this.phone = phone;
        this.roldid = roldid;
        this.image = image;
        this.gender = gender;
        this.createDate = createDate;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.username = username;
        this.id = id;
    }

    private String username;
    private String fullname;
    private String email;
    private String password;
    private Date createDate;
    private String gender;
    private String image;

    public String getRoldid() {
        return roldid;
    }

    public void setRoldid(String roldid) {
        this.roldid = roldid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", roldid='" + roldid + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    private String roldid;
    private String phone;

}
