package com.example.agebloomersbackend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="babysitters_matches")
public class BabysitterMatch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="match_date")
    private Date matchDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parents parent;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private Babysitters babysitter;
}
