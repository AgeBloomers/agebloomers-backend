package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "caregiver_matches")
public class CaregiverMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date matchDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "elder_id")
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregivers caregiver;
}
