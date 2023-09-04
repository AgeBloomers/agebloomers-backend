package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;

@Entity
public class CareInfoManage {
    @Id
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private String contact;
    private String email;
    private String password;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Character getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}