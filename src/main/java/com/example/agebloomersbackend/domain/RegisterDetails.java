package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "register_details")
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="register_date")
    private Date registerDate;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parents parent;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private Babysitters babysitter;

    @ManyToOne
    @JoinColumn(name = "elder_id")
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregivers caregiver;
}
