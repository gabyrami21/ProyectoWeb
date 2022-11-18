package com.example.Authentication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String pass;
    private String name;
    private String lastName;

    private String birthDate;
    private String position; // Cargo

   private boolean activo;
    

    public User() {
    }

    public User(String username, String password, String name, String lastName, String birthDate, String position,
             boolean activo) {
        this.username = username;
        this.pass = password;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.activo = activo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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


    public void setPass(String pass) {
        this.pass = pass;
    }

   public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}