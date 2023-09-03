package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "elders")
public class Elders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer contact;
    private String email;
    private String password;
}
