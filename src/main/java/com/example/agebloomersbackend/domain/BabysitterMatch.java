package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Table(name="babysitter_matches")
public class BabysitterMatch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    @JoinColumn(name = "parent_id", nullable = false)
    private Parents parent;

    @ManyToOne
    @JoinColumn(name = "babysitter_id", nullable = false)
    private Babysitters babysitter;

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
    public void setProposer(String proposer) {
        this.proposer = proposer;
    }
    public void setBabysitterId(Long babysitterId) {
        if (babysitter == null) {
            babysitter = new Babysitters();
        }
        babysitter.setId(babysitterId);
    }

    public void setParentId(Long parentId) {
        if (parent == null) {
            parent = new Parents();
        }
        parent.setId(parentId);
    }
}
