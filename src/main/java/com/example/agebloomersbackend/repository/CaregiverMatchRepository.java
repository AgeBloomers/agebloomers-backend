package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.CaregiverMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CaregiverMatchRepository extends JpaRepository<CaregiverMatch, Long> {
    @Query("SELECT bm.caregiver.id FROM CaregiverMatch bm")
    List<Long> findAllCaregiverIds();

    @Query("SELECT bm.elder.id FROM CaregiverMatch bm")
    List<Long> findAllElderIds();
}
