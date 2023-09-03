package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "caregiver_matches")
public class CaregiverMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="match_date", nullable = false)
    private Date matchDate;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @ManyToOne
    @JoinColumn(name = "elder_id", nullable = false)
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id", nullable = false)
    private Caregivers caregiver;
}
