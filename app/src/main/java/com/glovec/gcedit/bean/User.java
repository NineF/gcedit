package com.glovec.gcedit.bean;

/**
 * Created by everyone on 2017/4/12.
 */

public class User {
    private int userId;
    private String username;
    private String userpassword;

    public User(int userId, String username, String userpassword) {
        this.userId = userId;
        this.username = username;
        this.userpassword = userpassword;
    }
    public User(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
