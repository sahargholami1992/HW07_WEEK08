package org.example.domain;

import org.example.base.domain.BaseEntity;

public class User extends BaseEntity {
    public static final String TABLE_NAME ="users";
    public static final String USER_NAME = "user_name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String NAME = "name_user";
    private String userName;
    private String email;
    private String password;

    public User(String name, String userName, String email, String password) {

    }
    public User(long id,String name, String userName, String email, String password) {
    }


    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
