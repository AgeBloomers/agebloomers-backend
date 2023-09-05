package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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

    public void setId(Long id) {
        this.id = id;
    }
    public void setRegisterDate(Date registerDate) {this.registerDate = registerDate;}
    public void setComment(String comment) {this.comment = comment;}
    public void setStartTime(Date startTime) {this.startTime = startTime;}
    public void setEndTime(Date endTime) {this.endTime = endTime;}
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
