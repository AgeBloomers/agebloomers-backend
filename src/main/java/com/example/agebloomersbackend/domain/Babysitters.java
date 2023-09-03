package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "babysitters")
public class Babysitters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="gender")
    private Character gender;

    private Character address;

    @Column(name="contact")
    private Integer contact;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

}