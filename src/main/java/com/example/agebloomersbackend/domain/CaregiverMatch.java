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
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="match_date")
    private Date matchDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "elder_id")
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregivers caregiver;
}
