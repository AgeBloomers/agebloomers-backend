package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "caregivers")
public class Caregivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Character gender;
    private Integer contact;
    private String email;
    private String password;
}
