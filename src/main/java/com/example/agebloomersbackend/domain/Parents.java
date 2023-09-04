package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "parents")
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private Character gender;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "contact", nullable = false, length = 20)
    private String contact;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {this.name = name;}
    public void setAge(Integer age) {this.age = age;}
    public void setGender(Character gender) {this.gender = gender;}
    public void setAddress(String address) {this.address = address;}
    public void setContact(String contact) {this.contact = contact;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}

}