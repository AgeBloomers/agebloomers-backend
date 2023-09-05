package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CareInfoManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="name", nullable = false, length = 255)
    private String name;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="gender", nullable = false)
    private Character gender;

    @Column(name="address", nullable = false, length = 50)
    private String address;

    @Column(name="contact", nullable = false, length = 20)
    private String contact;

    @Column(name="email", nullable = false, length = 255)
    private String email;

    @Column(name="password", nullable = false, length = 255)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "register_date", nullable = false)
    private Date registerDate;

    @Column(name = "comment", nullable = true, length = 255)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time", nullable = false)
    private Date endTime;

//    @ManyToOne
//    @JoinColumn(name = "parent_id", nullable = true)
//    private Parents parent;
//
//    @ManyToOne
//    @JoinColumn(name = "babysitter_id", nullable = true)
//    private Babysitters babysitter;
//
//    @ManyToOne
//    @JoinColumn(name = "elder_id", nullable = true)
//    private Elders elder;
//
//    @ManyToOne
//    @JoinColumn(name = "caregiver_id", nullable = true)
//    private Caregivers caregiver;

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
    public Date getRegister_date() {return registerDate;}
    public String getComment() {return comment;}
    public Date getStart_time() {return startTime;}
    public Date getEnd_time() {return endTime;}

}