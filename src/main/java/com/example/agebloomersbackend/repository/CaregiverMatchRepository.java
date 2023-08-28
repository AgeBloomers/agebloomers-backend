package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.CaregiverMatch;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CaregiverMatchRepository extends JpaRepository<CaregiverMatch, Long> {
}
