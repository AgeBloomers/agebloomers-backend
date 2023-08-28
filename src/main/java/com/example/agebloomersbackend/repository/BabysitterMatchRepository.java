package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BabysitterMatchRepository extends JpaRepository<BabysitterMatch, Long> {
}
