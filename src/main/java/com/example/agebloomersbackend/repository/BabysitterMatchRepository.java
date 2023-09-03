package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BabysitterMatchRepository extends JpaRepository<BabysitterMatch, Long> {
    @Query("SELECT bm.babysitter.id FROM BabysitterMatch bm")
    List<Long> findAllBabysitterIds();
}
