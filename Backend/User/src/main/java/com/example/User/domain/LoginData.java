package com.example.User.domain;

public class LoginData {

    private String username;

    private String pass;

    public LoginData(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String contrasenia) {
        this.pass = pass;
    }
}
