package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "register_details")
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    private Parents parent;

    @ManyToOne
    @JoinColumn(name = "babysitter_id", nullable = true)
    private Babysitters babysitter;

    @ManyToOne
    @JoinColumn(name = "elder_id", nullable = true)
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id", nullable = true)
    private Caregivers caregiver;
}
