package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Table(name = "caregiver_matches")
public class CaregiverMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="match_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date matchDate;

    @Column(name = "status", nullable = false, length = 255, columnDefinition = "pending")
    private String status;

    @Column(name = "proposer", nullable = false, length = 50)
    private String proposer;

    @ManyToOne
    @JoinColumn(name = "elder_id", nullable = false)
    private Elders elder;

    @ManyToOne
    @JoinColumn(name = "caregiver_id", nullable = false)
    private Caregivers caregiver;

    public void setStatus(String status) { this.status = status; }
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public void setElderId(Long elderId) {
        if (elder == null) {
            elder = new Elders();
        }
        elder.setId(elderId);
    }

    public void setCaregiverId(Long caregiverId) {
        if (caregiver == null) {
            caregiver = new Caregivers();
        }
        caregiver.setId(caregiverId);
    }
}
