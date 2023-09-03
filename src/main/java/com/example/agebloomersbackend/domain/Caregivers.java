package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "caregivers")
public class Caregivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Character gender;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false, length = 20)
    private Integer contact;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
